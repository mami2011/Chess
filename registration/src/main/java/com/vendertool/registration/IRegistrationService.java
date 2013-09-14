package com.vendertool.registration;

import com.vendertool.common.service.IVenderToolService;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketRequest;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketResponse;
import com.vendertool.sharedtypes.rnr.ChangeEmailRequest;
import com.vendertool.sharedtypes.rnr.ChangeEmailResponse;
import com.vendertool.sharedtypes.rnr.ChangePasswordRequest;
import com.vendertool.sharedtypes.rnr.ChangePasswordResponse;
import com.vendertool.sharedtypes.rnr.CloseAccountRequest;
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


public interface IRegistrationService extends IVenderToolService {

	/**
	 * HTTP POST call to register an account
	 * 
	 * @param request
	 * @return
	 */
	public RegisterAccountResponse registerAccount(RegisterAccountRequest request);
	
	/**
	 * HTTP POST call to confirm registration
	 * 
	 * @param request
	 * @return
	 */
	public ConfirmRegistrationResponse confirmRegistration(ConfirmRegistrationRequest request);
	
	/**
	 * HTTP GET call to get the account details
	 * 
	 * @param request
	 * @return
	 */
	public GetAccountResponse getAccount(String username);
	
	/**
	 * HTTP POST to update the account details/profile
	 * 
	 * @param request
	 * @return
	 */
	public UpdateAccountResponse updateAccount(UpdateAccountRequest request);
	
	/**
	 * HTTP POST to change the password
	 * 
	 * @param request
	 * @return
	 */
	public ChangePasswordResponse changePassword(ChangePasswordRequest request);
	
	/**
	 * HTTP POST to change the email / username
	 * 
	 * @param request
	 * @return
	 */
	public ChangeEmailResponse changeEmail(ChangeEmailRequest request);
	
	/**
	 * HTTP POST call to close the account
	 * 
	 * @param request
	 * @return
	 */
	public CloseAccountResponse closeAccount(CloseAccountRequest request);
	
	/**
	 * HTTP POST to authorize market resources
	 * 
	 * @param request
	 * @return
	 */
	public AuthorizeMarketResponse authorizeMarket(AuthorizeMarketRequest request);
	
	/**
	 * HTTP POST to link other sites like FaceBook, Google, etc.
	 * 
	 * @param request
	 * @return
	 */
	public LinkOtherSiteResponse linkOtherSite(LinkOtherSiteRequest request);
}
