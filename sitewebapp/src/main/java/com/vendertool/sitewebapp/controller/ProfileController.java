package com.vendertool.sitewebapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.ErrorResponse;
import com.vendertool.sharedtypes.rnr.UpdateAccountRequest;
import com.vendertool.sitewebapp.common.MsgSource;
import com.vendertool.sitewebapp.util.MockDataUtil;

@Controller
public class ProfileController {
	private static final Logger logger = Logger.getLogger(ProfileController.class);
	private static final MsgSource MSG_SOURCE = new MsgSource();
	
	/**
	 * Main profile page. Displays account info.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="profile", method=RequestMethod.GET)
	public String getProfileView(ModelMap modelMap, HttpServletRequest request) {
		logger.info("getProfileView controller invoked");

		/***
		 * TODO: Getting the real data needs to be implemented.
		 */
		Account account = MockDataUtil.getAccount();
		
		ErrorResponse errorResponse = new ErrorResponse();

		modelMap.addAttribute("account", account);
		modelMap.addAttribute("errorResponse", errorResponse);
		modelMap.addAttribute("countryOptions", getCountryOptions(request));
		
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
		
		return "profile/main";
	}

	
	/**
	 * Save edited account.
	 *  
	 * @param account
	 * @param request
	 * @return
	 */
	@RequestMapping(value="profile/save", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveProfile(
			@RequestBody Account account, 
			HttpServletRequest request) {
		
		logger.info("saveProfile controller invoked");
		
		if (account == null) {
			throw new VTRuntimeException("Cannot update account. Account is null.");
		}

		UpdateAccountRequest updateAccountReq = new UpdateAccountRequest();
		updateAccountReq.setAccount(account);
		
		/********* This needs to be implemented ***********
		Response response = RestServiceUtil.post(
				updateAccountReq,
				"NEED_THIS_SERVICE_PATH",
				request);
		
		UpdateAccountResponse updateAccountRes = response.readEntity(UpdateAccountResponse.class);
		
		Account responseAccount = updateAccountRes.getAccount();
		responseAccount.clearPassword();
		ErrorResponse errorResponse = new ErrorResponse();
		
		if(updateAccountRes.hasErrors()) {
			logger.error("Update account failed with errors: " + updateAccountRes.getFieldBindingErrors());

			errorResponse = new ErrorResponse(updateAccountRes);
			
			Locale locale = RequestContextUtils.getLocale(request);
			VTErrorUtil.updateErrorsWithLocalizedMessages(errorResponse.getVTErrors(), locale);
			System.out.println("**** Default charset is: " + Charset.defaultCharset());

			
			//Added for debugging purpose, need to remove this
			//addJsonOutput(responseAccount, errorResponse, modelMap);
		}
		************************************************/
		
		/***
		 * TODO: Getting the real data needs to be implemented.
		 */
		Account responseAccount = account;
		ErrorResponse errorResponse = MockDataUtil.getUpdateAccountErrors(account);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", responseAccount);
		map.put("errorResponse", errorResponse);
		
		//Map<String, List<VTError>> errorMap = buildErrorMap(errorResponse);
		//map.put("errorMap", errorMap);
		
		return map;
	}
	
	/**
	 * Angular partial account.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/account", method = RequestMethod.GET)
	public String getAccountPartial(ModelMap modelMap, HttpServletRequest request) {
		logger.info("getAccountPartial controller invoked");
		
		//Map<String, String> countryMap = getCountryMap(request);
		//modelMap.put("countryMap", countryMap);
		
		return "profile/partial/account";
	}
	
	/**
	 * Angular partial email.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/email", method = RequestMethod.GET)
	public String getEmailPartial(ModelMap modelMap, HttpServletRequest request) {
		logger.info("getEmailPartial controller invoked");
		
		return "profile/partial/email";
	}
	
	/**
	 * Angular partial password.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/password", method = RequestMethod.GET)
	public String getPasswordPartial(ModelMap modelMap, HttpServletRequest request) {
		logger.info("getPasswordPartial controller invoked");
		
		return "profile/partial/password";
	}
	
	/**
	 * Gets a list of countries for the country select menu on the profile page.
	 * List includes the translated country name and its menu value.
	 * 
	 * @param request
	 * @return
	 */
	private static List<Map<String, String>> getCountryOptions(HttpServletRequest request) {
		
		List<Map<String, String>> countryOptions = new ArrayList<Map<String, String>>();
		Locale locale = RequestContextUtils.getLocale(request);

		CountryEnum[] countryEnums = CountryEnum.values();
		for (CountryEnum c : countryEnums) {
			String txt = MSG_SOURCE.getMessage(c.name(), null, locale);
			if (txt != null && txt.length() > 0) {
				Map<String, String> country = new HashMap<String, String>();
				country.put("val", c.name());
				country.put("txt", txt);
				countryOptions.add(country);
			}
		}

		return countryOptions;
	}

	
}
