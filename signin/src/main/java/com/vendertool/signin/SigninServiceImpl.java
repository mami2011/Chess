package com.vendertool.signin;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;

import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.sharedtypes.rnr.SigninRequest;
import com.vendertool.sharedtypes.rnr.SigninResponse;
import com.vendertool.sharedtypes.rnr.SignoutRequest;
import com.vendertool.sharedtypes.rnr.SignoutResponse;

@Path("/signin")
public class SigninServiceImpl extends BaseVenderToolServiceImpl implements
		ISigninService {

	@POST
	@Path("/signin")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public SigninResponse signin(SigninRequest request) {
		return null;
	}

	@POST
	@Path("/signout")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public SignoutResponse signout(SignoutRequest request) {
		return null;
	}

}
