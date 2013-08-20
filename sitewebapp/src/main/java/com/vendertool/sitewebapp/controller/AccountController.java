package com.vendertool.sitewebapp.controller;

import java.util.List;
import java.util.Map;

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
import com.vendertool.sitewebapp.common.FieldEnum;
import com.vendertool.sitewebapp.model.AccountFieldBuilder;
import com.vendertool.sitewebapp.model.Error;
import com.vendertool.sitewebapp.model.Field;
import com.vendertool.sitewebapp.model.Page;
import com.vendertool.sitewebapp.common.FieldEnum;

@Controller
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class);
	

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String getAccountPage(ModelMap modelMap) {
		logger.info("account GET controller invoked");
		

		
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

		Map<FieldEnum, Field> fieldMap = AccountFieldBuilder.getFieldMap();
		AccountFieldBuilder.setAccount(acct, fieldMap);
		
		Page page = new Page();
		page.setFieldMap(fieldMap);
		page.setUsername(acct.getEmailId());
		


		modelMap.put("page", page);
		
		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String pageJson= mapper.writeValueAsString(page);
			modelMap.put("pageJson", pageJson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "account";
	}
	

	@RequestMapping(value="account/save", method=RequestMethod.POST)
	public @ResponseBody Page saveAccount(@RequestBody Page page) {
		
		System.err.println(page.getFieldMap().get(FieldEnum.ADDRESS_LINE_1).getValue());
		
		Error error = new Error();
		error.setMessage("Please enter a valid address");
		page.getFieldMap().get(FieldEnum.ADDRESS_LINE_1).addError(error);
		
		Field f = page.getFieldMap().get(FieldEnum.ADDRESS_LINE_1);
		List<Error> errors = f.getErrors();
		
		System.err.println("===" + page.getFieldMap().get(FieldEnum.ADDRESS_LINE_1).getErrors().size());
		System.err.println(errors.get(0).getMessage());

		
		return page;
	}

	
	
	
	
}
