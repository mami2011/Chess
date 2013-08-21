package com.vendertool.sitewebapp.util;

import com.vendertool.sharedtypes.core.CountryEnum;

public class CountryUtil {

	public static final CountryEnum getCountryEnum(int countryId) {
		
		CountryEnum[] countries = CountryEnum.values();
		
		for (CountryEnum country : countries) {
			if (country.getId() == countryId) {
				return country;
			}
		}
		
		return null;
	}
}
