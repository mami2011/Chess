package com.vendertool.signin;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SigninResponse signin(SigninRequest request) {
		return null;
	}

	@POST
	@Path("/signout")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SignoutResponse signout(SignoutRequest request) {
		return null;
	}

}
