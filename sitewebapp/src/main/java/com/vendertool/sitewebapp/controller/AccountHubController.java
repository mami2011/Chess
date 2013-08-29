package com.vendertool.sitewebapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountHubController {
	@RequestMapping(value= {"accounthub", "accounthub/summary"}, method=RequestMethod.GET)
	public String getAccountHub(ModelMap modelMap, Principal principal) {
		
	    //String name = principal.getName();
	    //modelMap.addAttribute("email", name);
		modelMap.addAttribute("email", "ted@gmail.com");
		modelMap.addAttribute("name", "Ted");
		
		return "accounthub/accounthub";
	}
}
