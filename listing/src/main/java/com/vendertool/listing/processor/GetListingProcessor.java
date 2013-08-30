package com.vendertool.listing.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

public class GetListingProcessor  extends BaseListingProcessor {

	private static final Logger logger = Logger
			.getLogger(GetListingProcessor.class);

	private static class GetListingHelperHolder {
		private static final GetListingProcessor INSTANCE = new GetListingProcessor();
	}

	public static GetListingProcessor getInstance() {
		return GetListingHelperHolder.INSTANCE;
	}

	private GetListingProcessor() {
		super(ListingProcessorTypeEnum.GET_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in GetListingHelper");
			logger.debug(
					"NULL value passed to validate in GetListingHelper", ex);
			throw ex;
		}
		GetListingRequest getListingRequest = (GetListingRequest) request;
		GetListingResponse getListingResponse = (GetListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in GetListingHelper");
			logger.debug(
					"NULL value passed to performOperation in GetListingHelper",
					ex);
			throw ex;
		}
		
/*		CountryEnum countryId = CountryEnum.ALL;
		MarketEnum marketId = MarketEnum.MERCADO_LIBRE;

		IMarketListingAdapter adapter = ListingMarketAdapterRegistry
				.getInstance().getMarketListingAdapter(
						new MarketCountryKey(countryId, marketId));

		return adapter.getListing(id);*/
	}
}