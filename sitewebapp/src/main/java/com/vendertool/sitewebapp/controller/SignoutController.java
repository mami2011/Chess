package com.vendertool.sitewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignoutController {
//	private static final Logger logger = Logger.getLogger(SignoutController.class);
	
	@RequestMapping(value="signOut", method=RequestMethod.GET)
	public String getSignoutView(Model model){
//		logger.info("User initiated signout");
		return "signOut/signOut";
	}
}
