package com.vendertool.sitewebapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NgModulesController {
	private static final Logger logger = Logger.getLogger(NgModulesController.class);
	
	@RequestMapping(value = "sharedNgModules/fileUploaderModule", method = RequestMethod.GET)
	public String getFileUploaderTemplate() {
		logger.info("getFileUploaderTemplate controller invoked");
		return "sharedNgModules/fileUploaderModule";
	}
}
