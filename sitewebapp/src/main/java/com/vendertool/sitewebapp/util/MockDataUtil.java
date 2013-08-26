package com.vendertool.sitewebapp.util;

import java.util.HashMap;
import java.util.Map;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.Phone;
import com.vendertool.sharedtypes.core.Phone.PhoneType;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.rnr.ErrorResponse;


public class MockDataUtil {
	
	public static Account getAccount() {
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
	
	public static ErrorResponse getUpdateAccountErrors(Account account) {
		
		ErrorResponse response = new ErrorResponse();
		
		//combine both errors together before returning
		if(account.getContactDetails().getFirstName() == null || account.getContactDetails().getFirstName().isEmpty()) {
			response.addFieldBindingError(
					Errors.REGISTRATION.MISSING_FIRSTNAME, 
					account.getContactDetails().getClass().getName(),
					"firstName");
		}
		
		if(account.getContactDetails().getLastName() == null || account.getContactDetails().getLastName().isEmpty()) {
			response.addFieldBindingError(
					Errors.REGISTRATION.MISSING_LASTNAME,
					account.getContactDetails().getClass().getName(),
					"lastName");
		}


		return response;
	}
	
}