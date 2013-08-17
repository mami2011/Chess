package com.vendertool.sitewebapp.test.util;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sitewebapp.model.AccountFields;


public class MockDataUtil {

	public static AccountFields getAccountFields() {
		
		
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
		
		
		AccountFields fields = new AccountFields();
		fields.setAccount(acct);

		
		return fields;
	}
}
