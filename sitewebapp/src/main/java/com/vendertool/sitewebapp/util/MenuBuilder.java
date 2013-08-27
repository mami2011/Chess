package com.vendertool.sitewebapp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestContextUtils;

import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sitewebapp.common.MsgSource;

public class MenuBuilder {
	
	private static final MsgSource MSG_SOURCE = new MsgSource();
	
	public static List<Map<String, String>> getCountryOptions(HttpServletRequest request) {
		
		List<Map<String, String>> countryOptions = new ArrayList<Map<String, String>>();
		Locale locale = RequestContextUtils.getLocale(request);

		CountryEnum[] countryEnums = CountryEnum.values();
		for (CountryEnum c : countryEnums) {
			String txt = MSG_SOURCE.getMessage(c.name(), null, locale);
			if (txt != null && txt.length() > 0) {
				Map<String, String> country = new HashMap<String, String>();
				country.put("val", c.name());
				country.put("txt", txt);
				countryOptions.add(country);
			}
		}

		return countryOptions;
	}
	
	public static List<Map<String, String>> getLanguageOptions(Locale currLocale) {
		List<Map<String, String>> langOptions = new ArrayList<Map<String, String>>();
		Locale[] availLocales = java.util.Locale.getAvailableLocales();
		Set<Locale> allLocales = new HashSet<Locale>(Arrays.asList(availLocales));
		
		Map<String, String> langMap = new HashMap<String, String>();
		
		for (Locale loc : allLocales) {
			String txt = MSG_SOURCE.getMessage(loc.getLanguage(), null, currLocale);
			if (txt != null && txt.length() > 0) {
				langMap.put(loc.getLanguage(), txt);
			}
		}
		
		langMap = SortUtil.sortMapByValue(langMap);
		for (Map.Entry<String, String> entry : langMap.entrySet()) {
			Map<String, String> lang = new HashMap<String, String>();
			lang.put("val", entry.getKey());
			lang.put("txt", entry.getValue());
			langOptions.add(lang);
		}
		
		return langOptions;
	}
	
	
	
	
	public static void main(String[] args) {
		
		List<Map<String, String>> options = getLanguageOptions(Locale.US);
		
		for (Map<String, String> option: options) {
			System.out.println(option.get("txt"));
		}
		
	}
}
