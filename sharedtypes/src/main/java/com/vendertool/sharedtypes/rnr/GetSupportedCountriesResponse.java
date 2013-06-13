package com.vendertool.sharedtypes.rnr;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.CountryEnum;

@XmlRootElement
public class GetSupportedCountriesResponse extends BaseResponse {
	List<CountryEnum> countries;

	public List<CountryEnum> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryEnum> countries) {
		this.countries = countries;
	}
}
