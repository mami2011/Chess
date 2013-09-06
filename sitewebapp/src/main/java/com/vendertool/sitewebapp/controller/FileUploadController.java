package com.vendertool.sitewebapp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendertool.sharedtypes.core.FileInformation;
import com.vendertool.sharedtypes.core.FileUploadDataModel;
import com.vendertool.sharedtypes.core.HttpMethodEnum;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.ErrorResponse;
import com.vendertool.sharedtypes.rnr.FileUploadRequest;
import com.vendertool.sitewebapp.common.RestServiceClientHelper;
import com.vendertool.sitewebapp.common.URLConstants;

@Controller
public class FileUploadController {

	private static final Logger logger = Logger.getLogger(FileUploadController.class);

//	private static ValidationUtil validationUtil = ValidationUtil.getInstance();

	@RequestMapping(value=URLConstants.UPLOADS, method=RequestMethod.GET)
	public String getUploadsView(ModelMap modelMap, Principal principal) {
		logger.info("getUploadsView controller invoked");

		FileUploadDataModel fileUpload = new FileUploadDataModel();
		
		// TODO: principal is throwing error
		//modelMap.addAttribute("email", principal.getName());
		modelMap.addAttribute("email", "ted@gmail.com");
		modelMap.addAttribute("fileUpload", fileUpload);
		modelMap.addAttribute("errorResponse", new ErrorResponse());
		
		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String modelMapJson= mapper.writeValueAsString(modelMap);
			modelMap.put("modelMapJson", modelMapJson);
		}
		catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage(), e);
			e.printStackTrace();
			throw new VTRuntimeException("Cannot convert modelMap to json");
		}
		
		return "uploads/uploads";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("uploadFile") FileUploadDataModel uploadForm,
			Model map, HttpServletRequest request) throws IOException {

		MultipartFile file = uploadForm.getFile();
		FileUploadRequest fileRequest = null;
		if (file != null) {
			fileRequest = new FileUploadRequest();
			List<FileInformation> fileInformationList = new ArrayList<>();

			FileInformation fileInfo = new FileInformation();
			fileInfo.setFileData(file.getBytes());
			fileInfo.setFileName(file.getOriginalFilename());
			fileInfo.setFileSize(file.getSize());

			fileInformationList.add(fileInfo);
			fileRequest.setFiles(fileInformationList);
		}

		if (fileRequest != null) {
			String hostName = RestServiceClientHelper.getServerURL(request);
			String url = hostName + URLConstants.WEB_SERVICE_PATH
					+ URLConstants.FILE_UPLOAD_PATH;
			Response response = RestServiceClientHelper
					.invokeRestService(url, fileRequest, null, MediaType.APPLICATION_JSON_TYPE,
							HttpMethodEnum.POST);
		} else {
			// Error page.
		}
		return "fileUploadSuccess";
	}
	
	/*
	@RequestMapping(value = "fileUpload", method = RequestMethod.GET)
	public String getFileUploadPage(ModelMap modelMap, Principal principal) {
		// TODO validate session
		logger.info("fileUpload GET controller invoked");
		FileUploadDataModel uploadForm = new FileUploadDataModel();
		
		modelMap.addAttribute("email", principal.getName());
		modelMap.addAttribute("uploadFile", uploadForm);
		
		return "fileupload";
	}

	@RequestMapping(value = "fileUpload", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("uploadFile") FileUploadDataModel uploadForm,
			Model map, HttpServletRequest request) throws IOException {

		MultipartFile file = uploadForm.getFile();
		FileUploadRequest fileRequest = null;
		if (file != null) {
			fileRequest = new FileUploadRequest();
			List<FileInformation> fileInformationList = new ArrayList<>();

			FileInformation fileInfo = new FileInformation();
			fileInfo.setFileData(file.getBytes());
			fileInfo.setFileName(file.getOriginalFilename());
			fileInfo.setFileSize(file.getSize());

			fileInformationList.add(fileInfo);
			fileRequest.setFiles(fileInformationList);
		}

		if (fileRequest != null) {
			String hostName = RestServiceClientHelper.getServerURL(request);
			String url = hostName + URLConstants.WEB_SERVICE_PATH
					+ URLConstants.FILE_UPLOAD_PATH;
			Response response = RestServiceClientHelper
					.invokeRestService(url, fileRequest, null, MediaType.APPLICATION_JSON_TYPE,
							HttpMethodEnum.POST);
		} else {
			// Error page.
		}
		return "fileUploadSuccess";
	}*/
	
	/******************************************
	 * 
	 * Get partial pages for Angular
	 * 
	 ******************************************/
	@RequestMapping(value = "accounthub/uploads/partial/files", method = RequestMethod.GET)
	public String getFilesPartial() {
		logger.info("getFilesPartial controller invoked");
		return "uploads/partial/files";
	}
	
	@RequestMapping(value = "accounthub/uploads/partial/uploader", method = RequestMethod.GET)
	public String getUploaderPartial() {
		logger.info("getUploaderPartial controller invoked");
		return "uploads/partial/uploader";
	}
	
}