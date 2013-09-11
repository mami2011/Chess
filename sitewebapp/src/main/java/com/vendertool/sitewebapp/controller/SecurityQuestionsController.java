package com.vendertool.sitewebapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.vendertool.sharedtypes.core.Language;
import com.vendertool.sharedtypes.core.Signin;
import com.vendertool.sharedtypes.rnr.SigninRequest;
import com.vendertool.sitewebapp.util.MenuBuilder;

@Controller
public class SecurityQuestionsController {
	private static final Logger logger = Logger.getLogger(SecurityQuestionsController.class);
	
	@RequestMapping(value="questions", method=RequestMethod.GET)
	public String getSecurityQuestionsView(Model model, HttpServletRequest request){
		logger.info("getSecurityQuestionsView GET controller invoked");
		
		Locale locale = RequestContextUtils.getLocale(request);

		Signin signin = new Signin();
		model.addAttribute("signin", signin);
		model.addAttribute("languages", Language.getLanguages());
		model.addAttribute("langOptions", MenuBuilder.getLanguageOptions(locale));
		model.addAttribute("selectedLang", request.getParameter("lang"));
		
		return "securityQuestions/securityQuestions";
	}
	

	
	
	

}
