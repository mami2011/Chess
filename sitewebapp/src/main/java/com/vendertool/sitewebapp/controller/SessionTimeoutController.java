package com.vendertool.sitewebapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.vendertool.sitewebapp.util.MenuBuilder;

@Controller
public class SessionTimeoutController {

//	private static final Logger logger = Logger.getLogger(SessionTimeoutController.class);

	@RequestMapping(value = "sessionTimeout", method = RequestMethod.GET)
	public String confirmRegistration(ModelMap modelMap, HttpServletRequest request) {
///		logger.log(Level.INFO, "sessionTimeout GET controller invoked");
		
		Locale locale = RequestContextUtils.getLocale(request);
		modelMap.addAttribute("langOptions", MenuBuilder.getLanguageOptions(locale));
		modelMap.addAttribute("selectedLang", request.getParameter("lang"));
		
		return "sessionTimeout/sessionTimeout";
	}
}
