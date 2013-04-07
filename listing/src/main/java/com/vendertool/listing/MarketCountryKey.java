package com.vendertool.listing;

import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.MarketEnum;
import com.vendertool.sharedtypes.exception.VTRuntimeException;

public class MarketCountryKey {
	private CountryEnum countryId;
	private MarketEnum marketId;
	
	public MarketCountryKey(CountryEnum countryId, MarketEnum marketId) {
		if((countryId == null) || (marketId == null)) {
			throw new VTRuntimeException("MarketCountryKey: countryId or " +
					"marketId cannot be null");
		}
		this.countryId = countryId;
		this.marketId = marketId;
	}

	public MarketEnum getMarketId() {
		return marketId;
	}
	
	public CountryEnum getCountryId() {
		return countryId;
	}

	public boolean equals(MarketCountryKey key) {
		if(key == null) {
			return false;
		}
		
		return ((getCountryId() == key.getCountryId()) && 
				(getMarketId() == key.getMarketId()));
	}
}
