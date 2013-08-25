package com.vendertool.sitewebapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.Phone;
import com.vendertool.sharedtypes.core.Phone.PhoneType;
import com.vendertool.sharedtypes.error.CommonErrorCode;
import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.error.VTErrorFieldBindingMap;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.ErrorResponse;
import com.vendertool.sharedtypes.rnr.UpdateAccountRequest;

@Controller
public class ProfileController {
	private static final Logger logger = Logger.getLogger(ProfileController.class);

	@RequestMapping(value="profile", method=RequestMethod.GET)
	public String getProfileView(ModelMap modelMap) {
		logger.info("getProfileView controller invoked");

		/***
		 * TODO: Getting the real data needs to be implemented.
		 */
		Account account = getAccount();
		
		ErrorResponse errorResponse = new ErrorResponse();

		modelMap.addAttribute("account", account);
		modelMap.addAttribute("errorResponse", errorResponse);
		
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
	 * Main profile page. Displays current profile info.
	 * 
	 * @param modelMap
	 * @return
	 
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String getProfilePage(ModelMap modelMap) {
		logger.info("profile GET controller invoked");
		
		Account acct = getAccount();

		Map<String, String> profile = ProfileBuilder.getProfile(acct);
		modelMap.put("profile", profile);
		
		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String profileJson= mapper.writeValueAsString(profile);
			modelMap.put("profileJson", profileJson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "profile/main";
	}*/
	
	/**
	 * Save edited profile.
	 * 
	 * @RequestMapping(value="profile/save", method=RequestMethod.POST)
	public @ResponseBody ModelMap saveProfile(
			@RequestBody Account account, 
			HttpServletRequest request,
			ModelMap modelMap) {
			
	 * @param profile
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
		ErrorResponse errorResponse = getUpdateAccountErrors();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", responseAccount);
		Map<String, List<VTError>> errorMap = buildErrorMap(errorResponse);
		map.put("errorMap", errorMap);
		
		return map;
	}
	
	/**
	 * Angular partial account.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/account", method = RequestMethod.GET)
	public String getAccountPartial(ModelMap modelMap) {
		logger.info("getAccountPartial controller invoked");

		return "profile/partial/account";
	}
	
	/**
	 * Angular partial pageEdit.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/profileEdit", method = RequestMethod.GET)
	public String getProfileEditPartial(ModelMap modelMap) {
		
		Map<String, String> countryMap = new LinkedHashMap<String, String>();

		CountryEnum[] countryEnums = CountryEnum.values();
		for (CountryEnum ce : countryEnums) {
			countryMap.put(ce.getId() + "", ce.getDisplayName());
		}
		
		modelMap.put("countryMap", countryMap);

		return "profile/partial/profileEdit";
	}
	
	private static Account getAccount() {
		Address address = new Address();
		address.setAddressLine1("123 Main St");
		address.setAddressLine2("Apt. B");
		address.setCity("San Jose");
		address.setState("CA");
		address.setZip("95125");
		address.setCountry(CountryEnum.UNITED_STATES);
		ContactDetails contact = new ContactDetails();
		contact.setAddress(address);
		contact.setFirstName("Ted");
		contact.setLastName("Szeto");
		Account acct = new Account();
		acct.setEmailId("ted@gmail.com");
		acct.setContactDetails(contact);
		
		Phone workPhone = new Phone();
		workPhone.setAreaCode(408);
		workPhone.setCountryCode(011);
		workPhone.setNumber(5555555);
		workPhone.setType(PhoneType.WORK);
		Map<PhoneType, Phone> phones = new HashMap<PhoneType, Phone>();
		phones.put(workPhone.getType(), workPhone);
		contact.setPhones(phones);
		
		return acct;
	}
	
	private static ErrorResponse getUpdateAccountErrors() {
		
		ErrorResponse res = new ErrorResponse();

		VTError vtError = new VTError();
		vtError.setMessage("First name cannot be empty");
		
		VTErrorFieldBindingMap errorMap = new VTErrorFieldBindingMap(vtError, ContactDetails.class.getName(), "firstName");
		
		
		List<VTErrorFieldBindingMap> errors = new ArrayList<VTErrorFieldBindingMap>();
		errors.add(errorMap);
		res.setFieldBindingErrors(errors);

		return res;
	}
	
	private static Map<String, List<VTError>> buildErrorMap(ErrorResponse errorResponse) {
		Map<String, List<VTError>> errorMap = new HashMap<String, List<VTError>>();
		

		List<VTError> firstNameErrors = errorResponse.getFieldErrors(ContactDetails.class.getName(), "firstName");
		List<VTError> lastNameErrors = errorResponse.getFieldErrors(ContactDetails.class.getName(), "lastName");
		
		
		errorMap.put("firstName", firstNameErrors);
		errorMap.put("lastName", lastNameErrors);
		
		
		return errorMap;
	}
	

	

	
	
	
	
}
