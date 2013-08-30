package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.common.MarketCountryKey;
import com.vendertool.listing.ListingMarketAdapterRegistry;
import com.vendertool.mercadolibreadapter.IMarketListingAdapter;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class AddListingProcessor extends BaseListingProcessor {

	private static final Logger logger = Logger
			.getLogger(AddListingProcessor.class);

	private static class AddListingHelperHolder {
		private static final AddListingProcessor INSTANCE = new AddListingProcessor();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static AddListingProcessor getInstance() {
		return AddListingHelperHolder.INSTANCE;
	}

	private AddListingProcessor() {
		super(ListingProcessorTypeEnum.ADD_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in AddListingHelper");
			logger.debug("NULL value passed to validate in AddListingHelper",
					ex);
			throw ex;
		}
		AddListingRequest addListingRequest = (AddListingRequest) request;
		AddListingResponse addListingResponse = (AddListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in AddListingHelper");
			logger.debug(
					"NULL value passed to performOperation in AddListingHelper",
					ex);
			throw ex;
		}
		AddListingRequest addListingRequest = (AddListingRequest) request;
		AddListingResponse addListingResponse = (AddListingResponse) response;
		// TODO Do operation

		// Make call to Mer
		Listing listing = addListingRequest.getListing();
		IMarketListingAdapter adapter = ListingMarketAdapterRegistry
				.getInstance().getMarketListingAdapter(
						new MarketCountryKey(listing.getCountry(), listing
								.getMarket()));
		adapter.addListing(addListingRequest);

		// TODO update DB
	}
}