package com.vendertool.sharedtypes.rnr;

import java.util.Locale;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetSupportedLocalesResponse extends BaseResponse {
	private Set<Locale> locales;

	public Set<Locale> getLocales() {
		return locales;
	}

	public void setLocales(Set<Locale> locales) {
		this.locales = locales;
	}
}
