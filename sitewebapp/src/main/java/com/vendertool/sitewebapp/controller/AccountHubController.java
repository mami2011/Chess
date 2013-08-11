package com.vendertool.sitewebapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountHubController {
	@RequestMapping(value="accounthub", method=RequestMethod.GET)
	public String getAccountHub(ModelMap modelMap) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    modelMap.addAttribute("username", name);

		return "accounthub";
	}
}
