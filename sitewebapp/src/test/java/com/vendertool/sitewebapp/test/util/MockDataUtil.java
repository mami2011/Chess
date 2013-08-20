package com.vendertool.sitewebapp.test.util;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sitewebapp.common.FieldEnum;
import com.vendertool.sitewebapp.model.AccountFieldBuilder;
import com.vendertool.sitewebapp.model.Field;
import com.vendertool.sitewebapp.model.Page;


public class MockDataUtil {
	
	public static Page getAccountPage() {
		
		
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

		return page;
	}
	
	/*
	public static AccountFieldSet getAccountFieldSet() {
		
		
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
		
		
		AccountFieldSet fieldSet = new AccountFieldSet();
		fieldSet.setAccount(acct);

		
		return fieldSet;
	}*/
	
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		

		String json = "{\"username\":\"ted@gmail.com\",\"fields\":{\"EMAIL\":{\"name\":\"email\",\"value\":null,\"options\":null,\"errors\":null},\"PASSWORD_CONFIRM\":{\"name\":\"passwordConfirm\",\"value\":null,\"options\":null,\"errors\":null},\"PHONE_HOME\":{\"name\":\"phoneHome\",\"value\":null,\"options\":null,\"errors\":null},\"CITY\":{\"name\":\"city\",\"value\":null,\"options\":null,\"errors\":null},\"PHONE_MOBILE\":{\"name\":\"phoneMobile\",\"value\":null,\"options\":null,\"errors\":null},\"STATE\":{\"name\":\"state\",\"value\":null,\"options\":null,\"errors\":null},\"ADDRESS_LINE_2\":{\"name\":\"addressLine2\",\"value\":null,\"options\":null,\"errors\":null},\"PHONE_WORK\":{\"name\":\"phoneWork\",\"value\":null,\"options\":null,\"errors\":null},\"ADDRESS_LINE_1\":{\"name\":\"addressLine1\",\"value\":null,\"options\":null,\"errors\":null},\"COUNTRY\":{\"name\":\"country\",\"value\":null,\"options\":null,\"errors\":null},\"ZIP\":{\"name\":\"zip\",\"value\":null,\"options\":null,\"errors\":null},\"PASSWORD\":{\"name\":\"password\",\"value\":null,\"options\":null,\"errors\":null}},\"pageErrors\":null}";
		
		Page page = getAccountPage();
		try {
			//json = mapper.writeValueAsString(page);
			System.err.println(json);
			
			page = mapper.readValue(json, Page.class);
			
			System.err.println(page.getUsername());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		//System.out.println(acct.getEmail());
		
		
	}
}
