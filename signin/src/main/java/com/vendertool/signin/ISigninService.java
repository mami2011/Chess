package com.vendertool.signin;

import com.vendertool.common.service.IVenderToolService;
import com.vendertool.sharedtypes.rnr.SigninRequest;
import com.vendertool.sharedtypes.rnr.SigninResponse;
import com.vendertool.sharedtypes.rnr.SignoutRequest;
import com.vendertool.sharedtypes.rnr.SignoutResponse;

public interface ISigninService extends IVenderToolService {
	/**
	 * HTTP POST call to login
	 * 
	 * @param request
	 * @return
	 */
	public SigninResponse signin(SigninRequest request);
	
	/**
	 * HTTP POST call to logout
	 * 
	 * @param request
	 * @return
	 */
	public SignoutResponse signout(SignoutRequest request);
}
