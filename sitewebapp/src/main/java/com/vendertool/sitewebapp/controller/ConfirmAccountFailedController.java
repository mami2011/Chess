package com.vendertool.sitewebapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfirmAccountFailedController {
	private static final Logger logger = Logger.getLogger(ConfirmAccountFailedController.class);
	
	@RequestMapping(value="confirmaccountfailed", method=RequestMethod.GET)
	public String getConfirmAccountFailedView(ModelMap modelMap) {
		logger.info("confirm account failed GET controller invoked");
		
		return "confirmaccountfailed";
	}
}
