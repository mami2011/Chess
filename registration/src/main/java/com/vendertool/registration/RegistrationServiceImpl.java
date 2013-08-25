package com.vendertool.registration;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.vendertool.common.SessionIdGenerator;
import com.vendertool.common.URLConstants;
import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.registration.bof.AccountBOF;
import com.vendertool.registration.email.RegistrationEmailHelper;
import com.vendertool.registration.validation.RegistrationValidator;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountClosureReasonCodeEnum;
import com.vendertool.sharedtypes.core.AccountConfirmation;
import com.vendertool.sharedtypes.core.AccountStatusEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketRequest;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketResponse;
import com.vendertool.sharedtypes.rnr.BaseResponse.ResponseAckStatusEnum;
import com.vendertool.sharedtypes.rnr.CloseAccountResponse;
import com.vendertool.sharedtypes.rnr.ConfirmRegistrationRequest;
import com.vendertool.sharedtypes.rnr.ConfirmRegistrationResponse;
import com.vendertool.sharedtypes.rnr.GetAccountResponse;
import com.vendertool.sharedtypes.rnr.LinkOtherSiteRequest;
import com.vendertool.sharedtypes.rnr.LinkOtherSiteResponse;
import com.vendertool.sharedtypes.rnr.RegisterAccountRequest;
import com.vendertool.sharedtypes.rnr.RegisterAccountResponse;
import com.vendertool.sharedtypes.rnr.UpdateAccountRequest;
import com.vendertool.sharedtypes.rnr.UpdateAccountResponse;

@Path("/registration")
public class RegistrationServiceImpl extends BaseVenderToolServiceImpl
		implements IRegistrationService {
	
	@Context
	UriInfo uri;
	@Context
    HttpServletRequest httpServletRequest;
	@Context
    HttpServletResponse httpServletResponse;
	
	private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
	private CachedRegistrationAccountDatasource cachedDS;
	private static int RANDOM_CODE_DIGIT_COUNT = 5;
	private static int MAX_ACCOUNT_RETRY_ATTEMPTS = 3;
	private static ValidationUtil validationUtil = ValidationUtil.getInstance();

	//Set up few things as part of the constructor
	public RegistrationServiceImpl() {
		cachedDS = CachedRegistrationAccountDatasource.getInstance();
	}
	
	@POST
	@Path("/register")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public RegisterAccountResponse registerAccount(
			RegisterAccountRequest request) {
		
		//check for nulls in the validator
		RegisterAccountResponse response = new RegisterAccountResponse();
		RegistrationValidator rv = new RegistrationValidator();
		rv.validate(request, response);
		if(response.hasErrors()){
			if(request != null) {
				if(request.getAccount() != null) {
					request.getAccount().clearPassword();
				}
				response.setAccount(request.getAccount());
			}
			response.setSuccess(false);
			return response;
		}
		
		Account account = request.getAccount();
		setupAccountForRegistration(account);
		
		CachedRegistrationAccountDatasource.Status status = 
				CachedRegistrationAccountDatasource.Status.INVALID;
		try {
			String hashedPassword = saltHashPassword(account);
			account.setPassword(hashedPassword);
			account.setConfirmPassword(hashedPassword);
			
			//replace this with real DB call & shield it with try/catch
			status = cachedDS.addAccount(account);
			if(status == CachedRegistrationAccountDatasource.Status.NEW) {
				
				
				AccountBOF.getInstance().insert(account);
				response.setSuccess(true);
				response.setAccount(account);
				
				Locale locale = getLocale();
				String baseurl = getBaseUrl();
		    	
				RegistrationEmailHelper.getInstance().sendConfirmRegistrationEmail(
						account, baseurl, locale);
//				account.clearPassword();
//				account.clearAccountConfirmation();
				return response;
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage(), ex);
			cachedDS.removeAccount(account.getEmailId());
//			account.clearPassword();
//			account.clearAccountConfirmation();
		}

		response.setSuccess(false);
		response.setAccount(account);
		//Since we know it's going to be an error, clear the password
//		account.clearPassword();
//		account.clearAccountConfirmation();
		
		if(status == CachedRegistrationAccountDatasource.Status.EXISTING) {
			logger.debug("Username: '" + account.getEmailId() + "' already exists");
			response.addFieldBindingError(Errors.REGISTRATION.EMAIL_ALREADY_REGISTERED, account.getClass().getName(), "emailId");
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		logger.debug("System internal error during registration of account '" + account.getEmailId() + "'.");
		response.addFieldBindingError(Errors.SYSTEM.INTERNAL_ERROR, null, (String[])null);
		response.setStatus(ResponseAckStatusEnum.FAILURE);
		return response;
	}

	//Use this for new registration, email change & password change functionality
	private void setupAccountForRegistration(Account account) {
		account.setAccountStatus(AccountStatusEnum.NOT_VERIFIED);
		
		AccountConfirmation ac = new AccountConfirmation();
		SessionIdGenerator sidg = SessionIdGenerator.getInstance();
		
		String passwordSalt = sidg.generateSessionId(false);
		account.setPasswordSalt(passwordSalt);
		
		String sessionId = sidg.generateSessionId(true);
		Integer code = sidg.getRandomNumber(RANDOM_CODE_DIGIT_COUNT);
		ac.setConfirmCode(code);
		ac.setConfirmSessionId(sessionId);
		account.setAccountConf(ac);
	}

	private String saltHashPassword(Account account) {
		WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();
		MessageDigestPasswordEncoder encoder = (MessageDigestPasswordEncoder) webAppContext
				.getBean("passwordEncoder");
		
		String salt = account.getPasswordSalt();
		String rawpwd = account.getPassword();
		
		String hashedPwd = encoder.encodePassword(rawpwd, salt);
		return hashedPwd;
	}

	private String getBaseUrl() {
		String url = uri.getBaseUri().getHost();
		int port = uri.getBaseUri().getPort();
		String baseurl = URLConstants.HTTP + url + ((port > 0) ? (URLConstants.PORT_SEPARATOR + port) : "");
		//clean up trailing '/'
//		if(baseurl.charAt(baseurl.length()-1) == '/') {
//			baseurl = baseurl.substring(0, baseurl.length()-1);
//		}
		return baseurl;
	}

	private Locale getLocale() {
		Locale locale = httpServletRequest.getLocale();
		if(locale == null) {
			locale = Locale.US;
		}
		return locale;
	}
	
	@POST
	@Path("/confirmRegistration")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ConfirmRegistrationResponse confirmRegistration(ConfirmRegistrationRequest request) {
		ConfirmRegistrationResponse response = new ConfirmRegistrationResponse();

		if (validationUtil.isNull(request)
				|| (validationUtil.isNull(request.getEmailId()) || 
						(validationUtil.isEmpty(request.getEmailId())))) {
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			response.addFieldBindingError(Errors.COMMON.NULL_ARGUMENT_PASSED, null, (String[])null);
			return response;
		}
		
		String emailId = request.getEmailId();
		Account account = cachedDS.getAccount(emailId);
		if(validationUtil.isNull(account)) {
			response.addFieldBindingError(Errors.REGISTRATION.ACCOUNT_NOT_FOUND, null, (String[])null);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		AccountConfirmation accountConf = account.getAccountConf();
		//Now increment the attempt count.
		accountConf.incrementAttempts();
		
		if(accountConf.getConfirmationAttempts() > MAX_ACCOUNT_RETRY_ATTEMPTS) {
			response.addFieldBindingError(Errors.REGISTRATION.MAX_ACCOUNT_RECONFIRM_ATTEMPTS_REACHED, null, (String[])null);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
		}
		
		String sessionId = accountConf.getConfirmSessionId();
		Integer code = accountConf.getConfirmCode();
		if( (!sessionId.equals(request.getAccountConf().getConfirmSessionId())) || 
				(!code.equals(accountConf.getConfirmCode())) ) {
			
			if(accountConf.getConfirmationAttempts() > MAX_ACCOUNT_RETRY_ATTEMPTS) {
				account.setAccountStatus(AccountStatusEnum.SUSPENDED);
			}
			cachedDS.updateAccount(account);
			
			//don't set the account to the response
			response.addFieldBindingError(Errors.REGISTRATION.UNAUTHORIZED_ACCOUNT_CONFIRMATION, null, (String[])null);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		account.setAccountStatus(AccountStatusEnum.VERIFIED);
		cachedDS.updateAccount(account);
		response.setSuccess(true);
		response.setStatus(ResponseAckStatusEnum.SUCCESS);
		
		Locale locale = getLocale();
		String baseurl = getBaseUrl();
    	
		RegistrationEmailHelper.getInstance().sendRegistrationCompleteEmail(
				account, baseurl, locale);
		
		return response;
	}
	

	@GET
	@Path("/getAccount")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GetAccountResponse getAccount(@QueryParam(value="username") String username) {
		CachedRegistrationAccountDatasource cachedDS = 
				CachedRegistrationAccountDatasource.getInstance();
		
		Account account = cachedDS.getAccount(username);
		GetAccountResponse response = new GetAccountResponse();
		if(account == null) {
			response.addFieldBindingError(Errors.REGISTRATION.ACCOUNT_NOT_FOUND, null, (String[])null);
			return response;
		}
		
//		account.clearPassword();
//		account.clearAccountConfirmation();
		response.setAccount(account);
		response.setStatus(ResponseAckStatusEnum.SUCCESS);
		return response;
	}

	@POST
	@Path("/updateAccount")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UpdateAccountResponse updateAccount(UpdateAccountRequest request) {
		return null;
	}

	@GET
	@Path("/closeAccount")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CloseAccountResponse closeAccount(@QueryParam(value="username") String username,
			@QueryParam(value="reason") AccountClosureReasonCodeEnum reasonCode, 
			@QueryParam(value="reasonmsg") String reasonMessage) {
		return null;
	}

	@POST
	@Path("/authorizeMarket")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public AuthorizeMarketResponse authorizeMarket(
			AuthorizeMarketRequest request) {
		return null;
	}

	@POST
	@Path("/linkOtherSite")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public LinkOtherSiteResponse linkOtherSite(LinkOtherSiteRequest request) {
		return null;
	}

}
