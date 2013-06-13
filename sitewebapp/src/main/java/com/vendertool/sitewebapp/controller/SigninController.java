package com.vendertool.sitewebapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.ClientResponse;
import com.vendertool.sharedtypes.core.HttpMethodEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.rnr.SigninRequest;
import com.vendertool.sharedtypes.rnr.SigninResponse;
import com.vendertool.sitewebapp.common.RestServiceClientHelper;

@Controller
public class SigninController {
	private static final Logger logger = Logger.getLogger(SigninController.class);
	
	private static final String WEB_SERVICE_PATH = "/vendertoolsrvs";
	private static final String SIGNIN_PATH = "/signin";
	
	
	@RequestMapping(value="signin", method=RequestMethod.GET)
	public String getSigninView(Model model){
		SigninRequest signinRequest = new SigninRequest();
		model.addAttribute("signinRequest", signinRequest);
		return "signin";
	}
	
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String signin(
			@Valid
			@ModelAttribute("signinRequest") SigninRequest signinRequest,
			ModelMap modelMap,
			HttpServletRequest request) {
		
		String hostName = request.getLocalName();
		String url = hostName + WEB_SERVICE_PATH + SIGNIN_PATH;
		
		ClientResponse response = RestServiceClientHelper
				.invokeRestService(url, signinRequest, null, MediaType.APPLICATION_JSON_TYPE,
						HttpMethodEnum.POST);
		
		if(response.getStatus() != 200) {
			return handleHttpFailure(modelMap, url, response);
			
		}
		
		SigninResponse signinResponse = response.getEntity(SigninResponse.class);
		if (signinResponse.hasErrors()) {
			return handleResponseError(signinRequest, modelMap, signinResponse);
		}
		
		modelMap.addAttribute("loginResponse", signinResponse);
		return "myhome.html";
	}

	
	
	private String handleResponseError(SigninRequest signinRequest,
			ModelMap modelMap, SigninResponse signinResponse) {
		logger.log(Level.INFO, signinResponse.getClass() + 
				" has errors: \n\t" + signinResponse.getErrors());

		//make sure to set the password to null
		signinRequest.getSignin().setPassword(null);
		
		//preserve the username so that the user doesn't have to enter it again
//			String username = signinResponse.getUserName();
//			if((username != null) && (!username.trim().isEmpty())) {
//				signinRequest.getSignin().setUsername(username);
//			}
		
		modelMap.addAttribute("signinRequest", signinRequest);
		modelMap.addAttribute("signinResponse", signinResponse);
		return "signin";
	}

	
	
	private String handleHttpFailure(ModelMap modelMap, String url,
			ClientResponse response) {
		logger.log(Level.ERROR, "HTTP response to POST to the service URI '" + 
				url + "' is not successful. HTTP response code is: " + response.getStatus());
		
		SigninResponse httpFailedresponse = new SigninResponse();
		httpFailedresponse.addError(Errors.SIGNIN.UNABLE_TO_SIGN_IN);
		
		SigninRequest blankRequest = new SigninRequest();
		
		modelMap.addAttribute("signinRequest", blankRequest);
		modelMap.addAttribute("signinResponse", httpFailedresponse);
		return "signin";
	}
}
