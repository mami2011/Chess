package com.vendertool.sitewebapp.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonSubTypes;
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
import com.vendertool.sharedtypes.error.CommonErrorCode;
import com.vendertool.sharedtypes.error.FTSErrorCode;
import com.vendertool.sharedtypes.error.InventoryErrorCode;
import com.vendertool.sharedtypes.error.ListingErrorCode;
import com.vendertool.sharedtypes.error.MetadataErrorCode;
import com.vendertool.sharedtypes.error.RegistrationErrorCode;
import com.vendertool.sharedtypes.error.SigninErrorCode;
import com.vendertool.sharedtypes.error.SystemErrorCode;
import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.error.VTErrorCode;
import com.vendertool.sitewebapp.builder.ProfileBuilder;

@Controller
public class ProfileController {
	private static final Logger logger = Logger.getLogger(ProfileController.class);
	
	/**
	 * Main profile page. Displays current profile info.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String getProfilePage(ModelMap modelMap) {
		logger.info("account GET controller invoked");
		
		//========================
		// Mock address object
		//========================
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
	}
	
	/**
	 * Save edited profile.
	 * 
	 * @param profile
	 * @return
	 */
	@RequestMapping(value="profile/save", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveProfile(@RequestBody Map<String, Object> profile) {
		
		//========================
		// Mock error objects
		//========================
		VTError error1 = new VTError();
		error1.setErrorCode(CommonErrorCode.NULL_ARGUMENT_PASSED);
		error1.setErrorMessage("Error is NULL_ARGUMENT_PASSED");
		VTError error2 = new VTError();
		error2.setErrorCode(SystemErrorCode.INTERNAL_DATABASE_DOWN);
		error2.setErrorMessage("Error is INTERNAL_DATABASE_DOWN");
		Map<String, VTError> errorMap = new HashMap<String, VTError>();
		errorMap.put(error1.getErrorCode().getErrorCode(), error1);
		errorMap.put(error2.getErrorCode().getErrorCode(), error2);
		
		System.err.println("error1 code: " + error1.getErrorCode().getErrorCode());
		System.err.println("error2 code: " + error2.getErrorCode().getErrorCode());
		
		profile.put("error", errorMap);
		
		return profile;
	}
	
	/**
	 * Angular partial profile.jsp has been requested via ajax.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "profile/partial/profile", method = RequestMethod.GET)
	public String getProfilePartial(ModelMap modelMap) {
		logger.info("AngularPartials GET controller invoked");

		return "profile/partial/profile";
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
	
	
	
	
	

	
	
	
	
}
