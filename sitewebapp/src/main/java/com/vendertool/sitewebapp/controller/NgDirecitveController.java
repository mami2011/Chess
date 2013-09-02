package com.vendertool.sitewebapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NgDirecitveController {
	private static final Logger logger = Logger.getLogger(NgDirecitveController.class);
	
	@RequestMapping(value = "directive/fileUploader", method = RequestMethod.GET)
	public String getFileUploaderTemplate() {
		logger.info("getFileUploaderTemplate controller invoked");
		return "ng-directive/fileUploader";
	}
}
