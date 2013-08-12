package com.vendertool.registration;

import java.util.List;

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

import com.vendertool.common.SessionIdGenerator;
import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.registration.email.RegistrationEmailHelper;
import com.vendertool.registration.validation.RegistrationValidator;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountClosureReasonCodeEnum;
import com.vendertool.sharedtypes.core.AccountConfirmation;
import com.vendertool.sharedtypes.core.AccountStatusEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.error.VTError;
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
		
		RegisterAccountResponse response = new RegisterAccountResponse();
		if(request == null) {
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			response.addError(Errors.COMMON.NULL_ARGUMENT_PASSED);
			return response;
		}
		
		RegistrationValidator rv = new RegistrationValidator();
		List<VTError> errors = rv.validate(request);
		if(!errors.isEmpty()){
			response.addErrors(errors);
			if(request != null) {
				response.setAccount(request.getAccount());
			}
			response.setSuccess(false);
			return response;
		}
		
		Account account = request.getAccount();
		account.setAccountStatus(AccountStatusEnum.NOT_VERIFIED);
		
		AccountConfirmation ac = new AccountConfirmation();
		SessionIdGenerator sidg = SessionIdGenerator.getInstance();
		String sessionId = sidg.generateSessionId(true);
		Integer code = sidg.getRandomNumber(RANDOM_CODE_DIGIT_COUNT);
		ac.setConfirmCode(code);
		ac.setConfirmSessionId(sessionId);
		account.setAccountConf(ac);
		
		//replace this with real DB call & shield it with try/catch
		CachedRegistrationAccountDatasource.Status status = 
					cachedDS.addAccount(account);
		if(status == CachedRegistrationAccountDatasource.Status.NEW) {
			response.setSuccess(true);
			response.setAccount(account);
			String baseurl = uri.getBaseUri().toString();
			RegistrationEmailHelper.sendRegistrationEmail(account, baseurl);
			return response;
		}

		response.setSuccess(false);
		response.setAccount(account);
		
		if(status == CachedRegistrationAccountDatasource.Status.EXISTING) {
			response.addError(Errors.REGISTRATION.EMAIL_ALREADY_REGISTERED);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		response.addError(Errors.SYSTEM.INTERNAL_ERROR);
		response.setStatus(ResponseAckStatusEnum.FAILURE);
		return response;
	}
	
	@POST
	@Path("/confirmRegistration")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ConfirmRegistrationResponse confirmRegistration(ConfirmRegistrationRequest request) {
		ConfirmRegistrationResponse response = new ConfirmRegistrationResponse();

		if (validationUtil.isNull(request)
				|| (validationUtil.isNull(request.getEmailId()) || (validationUtil
						.isEmpty(request.getEmailId())))) {
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			response.addError(Errors.COMMON.NULL_ARGUMENT_PASSED);
			return response;
		}
		
		String emailId = request.getEmailId();
		Account account = cachedDS.getAccount(emailId);
		if(validationUtil.isNull(account)) {
			response.addError(Errors.REGISTRATION.ACCOUNT_NOT_FOUND);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		AccountConfirmation accountConf = account.getAccountConf();
		//Now increment the attempt count.
		account.getAccountConf().incrementAttempts();
		
		if(accountConf.getConfirmationAttempts() > MAX_ACCOUNT_RETRY_ATTEMPTS) {
			response.addError(Errors.REGISTRATION.MAX_ACCOUNT_RECONFIRM_ATTEMPTS_REACHED);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
		}
		
		String sessionId = accountConf.getConfirmSessionId();
		Integer code = accountConf.getConfirmCode();
		if( (!sessionId.equals(request.getAccountConf().getConfirmSessionId())) || 
				(!code.equals(accountConf.getConfirmCode())) ) {
			
			if(account.getAccountConf().getConfirmationAttempts() > MAX_ACCOUNT_RETRY_ATTEMPTS) {
				account.setAccountStatus(AccountStatusEnum.SUSPENDED);
			}
			cachedDS.updateAccount(account);
			
			response.addError(Errors.REGISTRATION.UNAUTHORIZED_ACCOUNT_CONFIRMATION);
			response.setStatus(ResponseAckStatusEnum.FAILURE);
			return response;
		}
		
		account.setAccountStatus(AccountStatusEnum.VERIFIED);
		cachedDS.updateAccount(account);
		response.setSuccess(true);
		response.setStatus(ResponseAckStatusEnum.SUCCESS);
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
		if(account != null) {
			response.addError(Errors.REGISTRATION.ACCOUNT_NOT_FOUND);
		}
		
		return response;
	}

	public UpdateAccountResponse updateAccount(UpdateAccountRequest request) {
		return null;
	}

	public CloseAccountResponse closeAccount(String username,
			AccountClosureReasonCodeEnum reasonCode, String reasonMessage) {
		return null;
	}

	public AuthorizeMarketResponse authorizeMarket(
			AuthorizeMarketRequest request) {
		return null;
	}

	public LinkOtherSiteResponse linkOtherSite(LinkOtherSiteRequest request) {
		return null;
	}

}
