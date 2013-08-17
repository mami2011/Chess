package com.vendertool.sitewebapp.controller;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sitewebapp.model.AccountFields;
import com.vendertool.sitewebapp.test.util.MockDataUtil;

@Controller
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class);
	

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String getAccount(ModelMap modelMap) {
		logger.info("account GET controller invoked");
		
		AccountFields accountFields = MockDataUtil.getAccountFields();

		modelMap.put("accountFields", accountFields);
		
		// Add JSON for Angular
		try {
			ObjectMapper mapper = new ObjectMapper();
			String accountFieldsJson= mapper.writeValueAsString(accountFields);
			modelMap.put("accountFieldsJson", accountFieldsJson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "account";
	}
	
	@RequestMapping(value="account/save", method=RequestMethod.POST)
	public @ResponseBody String saveAccount(@RequestBody String accountFields) {
		ObjectMapper mapper = new ObjectMapper();
		AccountFields acctFlds = mapper.convertValue(accountFields, AccountFields.class);
		System.err.println(acctFlds.getAddressLine1());
		
		return accountFields;
	}
		
	
	
	
	
}
