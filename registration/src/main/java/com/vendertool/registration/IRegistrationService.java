package com.vendertool.registration;

import com.vendertool.common.service.IVenderToolService;
import com.vendertool.sharedtypes.core.AccountClosureReasonCodeEnum;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketRequest;
import com.vendertool.sharedtypes.rnr.AuthorizeMarketResponse;
import com.vendertool.sharedtypes.rnr.CloseAccountResponse;
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
	 * HTTP GET call to close the account
	 * 
	 * @param request
	 * @return
	 */
	public CloseAccountResponse closeAccount(String username,
			AccountClosureReasonCodeEnum reasonCode, String reasonMessage);
	
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
