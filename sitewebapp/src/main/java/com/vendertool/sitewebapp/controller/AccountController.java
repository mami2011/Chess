package com.vendertool.sitewebapp.controller;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;

@Controller
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class);
	

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String getAccount(ModelMap modelMap) {
		logger.info("account GET controller invoked");
		
		// Mock models
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
		acct.setContact(contact);
		
		modelMap.put("account", acct);
		
		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String acctJson= mapper.writeValueAsString(acct);
			modelMap.put("accountJson", acctJson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "account";
	}
	
	
	
	
	
}
