package com.vendertool.listing.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingPriceQuanityResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingPriceQuantityRequest;

public class UpdateListingPriceQuantityProcessor  extends BaseListingProcessor {

	private static final Logger logger = Logger
			.getLogger(AddListingProcessor.class);

	private static class UpdateListingPriceQuantityHelperHolder {
		private static final UpdateListingPriceQuantityProcessor INSTANCE = new UpdateListingPriceQuantityProcessor();
	}

	public static UpdateListingPriceQuantityProcessor getInstance() {
		return UpdateListingPriceQuantityHelperHolder.INSTANCE;
	}

	private UpdateListingPriceQuantityProcessor() {
		super(ListingProcessorTypeEnum.UPDATE_LISTING_PRICE_QTY);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in UpdateListingPriceQuantityHelper");
			logger.debug(
					"NULL value passed to validate in UpdateListingPriceQuantityHelper", ex);
			throw ex;
		}
		UpdateListingPriceQuantityRequest updateListingRequest = (UpdateListingPriceQuantityRequest) request;
		UpdateListingPriceQuanityResponse updateListingResponse = (UpdateListingPriceQuanityResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in UpdateListingPriceQuantityHelper");
			logger.debug(
					"NULL value passed to performOperation in UpdateListingPriceQuantityHelper",
					ex);
			throw ex;
		}
	}
}