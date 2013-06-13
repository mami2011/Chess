package com.vendertool.registration;

import com.vendertool.common.service.BaseVenderToolServiceImpl;
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

public class RegistrationServiceImpl extends BaseVenderToolServiceImpl
		implements IRegistrationService {

	public RegisterAccountResponse registerAccount(
			RegisterAccountRequest request) {
		return null;
	}

	public GetAccountResponse getAccount(String username) {
		return null;
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
