package com.vendertool.registration;

import java.util.List;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import com.vendertool.common.SessionIdGenerator;
import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.registration.validation.RegistrationValidator;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountClosureReasonCodeEnum;
import com.vendertool.sharedtypes.core.AccountConfirmation;
import com.vendertool.sharedtypes.core.AccountStatusEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketRequest;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketResponse;
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
	
	private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
	private CachedRegistrationAccountDatasource cachedDS;
	private static int RANDOM_CODE_DIGIT_COUNT = 5;

	//Set up few things as part of the constructor
	public RegistrationServiceImpl() {
		cachedDS = CachedRegistrationAccountDatasource.getInstance();
	}
	
	@POST
	@Path("/register")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public RegisterAccountResponse registerAccount(
			RegisterAccountRequest request) {
		
		RegisterAccountResponse response = new RegisterAccountResponse();
		
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
			return response;
		}

		response.setSuccess(false);
		response.setAccount(account);
		
		if(status == CachedRegistrationAccountDatasource.Status.EXISTING) {
			response.addError(Errors.REGISTRATION.EMAIL_ALREADY_REGISTERED);
			return response;
		}
		
		response.addError(Errors.SYSTEM.INTERNAL_ERROR);
		return response;
	}
	
	@POST
	@Path("/confirmRegistration")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public ConfirmRegistrationResponse confirmRegistration(ConfirmRegistrationRequest request) {
		
		return null;
	}
	

	@GET
	@Path("/getAccount")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
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
