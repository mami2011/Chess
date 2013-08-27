package com.vendertool.sitewebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vendertool.sharedtypes.core.Language;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String getAccountHub(ModelMap modelMap, HttpServletRequest request) {
		logger.info("home page GET controller invoked");
		
		modelMap.addAttribute("languages", Language.getLanguages());
		
		return "home";
	}
}