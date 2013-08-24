package com.vendertool.sitewebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionTimeoutController {

//	private static final Logger logger = Logger.getLogger(SessionTimeoutController.class);

	@RequestMapping(value = "sessionTimeout", method = RequestMethod.GET)
	public String confirmRegistration(HttpServletRequest httprequest) {
///		logger.log(Level.INFO, "sessionTimeout GET controller invoked");

		return "sessiontimeout";
	}
}
