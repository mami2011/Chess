package com.vendertool.sitewebapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.vendertool.sitewebapp.util.MenuBuilder;

@Controller
public class UnexpectedErrorPageController {

	private static final Logger logger = Logger.getLogger(UnexpectedErrorPageController.class);

	@RequestMapping(value="unexpectedError", method=RequestMethod.GET)
	public String getUnexpectedErrorView(ModelMap modelMap, HttpServletRequest request) {
		logger.info("register GET controller invoked");

		Locale locale = RequestContextUtils.getLocale(request);
		modelMap.addAttribute("langOptions", MenuBuilder.getLanguageOptions(locale));
		modelMap.addAttribute("selectedLang", request.getParameter("lang"));
		
		return "errors/unexpectedError";
	}
}