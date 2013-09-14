package com.vendertool.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.MarketEnum;

/**
 * TODO, read from the lookup table, once its ready & this class will be gone or this class can call
 * the DAL to read it from the db.
 */
public class MarketCountryConfig {
	private Map<MarketEnum, List<CountryEnum>> marketCountryMap;
	
	private static class MarketCountryConfigHolder {
		private static final MarketCountryConfig INSTANCE = new MarketCountryConfig();
	}
	
	private MarketCountryConfig() {
		marketCountryMap = new HashMap<MarketEnum, List<CountryEnum>>();
		addMercadoSupportedCountries();
		//addFacebookSupportedCountries();
		//addGoogleSupportedCountries();
		//addAmazonSupportedCountries();
		//addEbaySupportedCountries();
	}
	
	public static MarketCountryConfig getInstance() {
		return MarketCountryConfigHolder.INSTANCE;
	}
	
	public List<CountryEnum> getMarketSupportedCountries(MarketEnum market) {
		return marketCountryMap.get(market);
	}
	
	//TODO: read from the look up table
	private void addMercadoSupportedCountries() {
		if(marketCountryMap.containsKey(MarketEnum.MERCADO_LIBRE)) {
			return;
		}
		
		List<CountryEnum> countries = new ArrayList<CountryEnum>();
		countries.add(CountryEnum.ARGENTINA);
		countries.add(CountryEnum.BRAZIL);
		countries.add(CountryEnum.COLOMBIA);
		countries.add(CountryEnum.COSTA_RICA);
		countries.add(CountryEnum.CHILE);
		countries.add(CountryEnum.DOMINICA);
		countries.add(CountryEnum.ECUADOR);
		countries.add(CountryEnum.UNITED_STATES);
		countries.add(CountryEnum.MEXICO);
		countries.add(CountryEnum.PANAMA);
		countries.add(CountryEnum.PERU);
		countries.add(CountryEnum.PORTUGAL);
		countries.add(CountryEnum.URUGUAY);
		countries.add(CountryEnum.VENEZUELA);
		
		marketCountryMap.put(MarketEnum.MERCADO_LIBRE, countries);
	}
	
	public Set<Locale> getSupportedLocales(){
		Set<Locale> locales = new HashSet<Locale>();
		
		Set<MarketEnum> keys = marketCountryMap.keySet();
		for(MarketEnum key : keys) {
			List<CountryEnum> countries = marketCountryMap.get(key);
			for(CountryEnum country : countries) {
				locales.add(country.getLocale());
			}
		}
		return locales;
	}
}
