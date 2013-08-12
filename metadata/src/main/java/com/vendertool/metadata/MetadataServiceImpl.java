package com.vendertool.metadata;

import java.util.Locale;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.sharedtypes.core.MarketEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.rnr.GetSupportedCountriesResponse;
import com.vendertool.sharedtypes.rnr.GetSupportedLocalesResponse;

@Path("/metadata")
public class MetadataServiceImpl extends BaseVenderToolServiceImpl implements
		IMetadataService {

	@GET
	@Path("/getSupportedLocales")
	@ProduceMime({ "application/xml", "application/json" })
	public GetSupportedLocalesResponse getSupportedLocales() {
		GetSupportedLocalesResponse response = new GetSupportedLocalesResponse();
		Set<Locale> locales = MarketCountryConfig.getInstance().getSupportedLocales();
		response.setLocales(locales);
		return response;
	}

	@GET
	@Path("/getSupportedCountries")
	@ProduceMime({ "application/xml", "application/json" })
	public GetSupportedCountriesResponse getSupportedCountries(@QueryParam("market") MarketEnum market) {
		GetSupportedCountriesResponse response = new GetSupportedCountriesResponse();
		
		if(market == null) {
			response.addError(Errors.METADATA.MARKET_DATA_MISSING);
			return response;
		}
		
		response.setCountries(MarketCountryConfig
					.getInstance()
					.getMarketSupportedCountries(market));
		
		return response;
	}
}
