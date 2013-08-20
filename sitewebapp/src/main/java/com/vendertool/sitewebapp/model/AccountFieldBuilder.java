package com.vendertool.sitewebapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.Address;
import com.vendertool.sharedtypes.core.ContactDetails;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sitewebapp.common.FieldEnum;

public class AccountFieldBuilder {
	
	
	public static Map<FieldEnum, Field> getFieldMap() {
		
		Map<FieldEnum, Field> fields = new HashMap<FieldEnum, Field>();
		fields.put(FieldEnum.EMAIL, new Field().setType(FieldEnum.EMAIL));
		fields.put(FieldEnum.PASSWORD, new Field().setType(FieldEnum.PASSWORD));
		fields.put(FieldEnum.PASSWORD_CONFIRM, new Field().setType(FieldEnum.PASSWORD_CONFIRM));
		fields.put(FieldEnum.ADDRESS_LINE_1, new Field().setType(FieldEnum.ADDRESS_LINE_1));
		fields.put(FieldEnum.ADDRESS_LINE_2, new Field().setType(FieldEnum.ADDRESS_LINE_2));
		fields.put(FieldEnum.CITY, new Field().setType(FieldEnum.CITY));
		fields.put(FieldEnum.STATE, new Field().setType(FieldEnum.STATE));
		fields.put(FieldEnum.ZIP, new Field().setType(FieldEnum.ZIP));
		fields.put(FieldEnum.COUNTRY, new Field().setType(FieldEnum.COUNTRY));
		fields.put(FieldEnum.PHONE_WORK, new Field().setType(FieldEnum.PHONE_WORK));
		fields.put(FieldEnum.PHONE_MOBILE, new Field().setType(FieldEnum.PHONE_MOBILE));
		fields.put(FieldEnum.PHONE_HOME, new Field().setType(FieldEnum.PHONE_HOME));
		
		List<FieldOption> countries = new ArrayList<FieldOption>();
		for (CountryEnum c : CountryEnum.values()) {
			FieldOption opt = new FieldOption();
			opt.setLabel(c.getDisplayName());
			opt.setValue(c.getId() + "");
			countries.add(opt);
		}
		fields.get(FieldEnum.COUNTRY).setOptions(countries);
		
		return fields;
	}
	
	public static void setAccount(Account account, Map<FieldEnum, Field> fieldMap) {
		Field email = fieldMap.get(FieldEnum.EMAIL);
		Field password = fieldMap.get(FieldEnum.PASSWORD);
		Field addr1 = fieldMap.get(FieldEnum.ADDRESS_LINE_1);
		Field addr2 = fieldMap.get(FieldEnum.ADDRESS_LINE_2);
		Field city = fieldMap.get(FieldEnum.CITY);
		Field state = fieldMap.get(FieldEnum.STATE);
		Field zip = fieldMap.get(FieldEnum.ZIP);
		Field country = fieldMap.get(FieldEnum.COUNTRY);
		
		email.setValue(account.getEmailId());
		password.setValue(account.getPassword());
	
		ContactDetails contact = account.getContact();
		if (contact != null) {
			Address address = contact.getAddress();
			if (address != null) {
				addr1.setValue(address.getAddressLine1());
				addr2.setValue(address.getAddressLine2());
				city.setValue(address.getCity());
				state.setValue(address.getState());
				zip.setValue(address.getZip());
				
				CountryEnum countryEnum = address.getCountry();
				if (countryEnum != null) {
					country.setValue(countryEnum.getId() + "");
				}
			}
		}
	}
	
	
}
