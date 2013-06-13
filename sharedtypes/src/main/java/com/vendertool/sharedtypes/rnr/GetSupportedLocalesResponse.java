package com.vendertool.sharedtypes.rnr;

import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetSupportedLocalesResponse extends BaseResponse {
	private List<Locale> locales;

	public List<Locale> getLocales() {
		return locales;
	}

	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}
}
