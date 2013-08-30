package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetListingPriceQuantityRequest;
import com.vendertool.sharedtypes.rnr.GetListingPriceQuantityResponse;

public class GetListingPriceQuantityProcessor extends BaseListingProcessor {

	private static final Logger logger = Logger
			.getLogger(GetListingPriceQuantityProcessor.class);

	private static class GetListingPriceQuantityHelperHolder {
		private static final GetListingPriceQuantityProcessor INSTANCE = new GetListingPriceQuantityProcessor();
	}

	public static GetListingPriceQuantityProcessor getInstance() {
		return GetListingPriceQuantityHelperHolder.INSTANCE;
	}

	private GetListingPriceQuantityProcessor() {
		super(ListingProcessorTypeEnum.GET_LISTING_PRICE_QTY);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in GetListingPriceQuantityHelper");
			logger.debug(
					"NULL value passed to validate in GetListingPriceQuantityHelper", ex);
			throw ex;
		}
		GetListingPriceQuantityRequest getListingRequest = (GetListingPriceQuantityRequest) request;
		GetListingPriceQuantityResponse getListingResponse = (GetListingPriceQuantityResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in GetListingPriceQuantityHelper");
			logger.debug(
					"NULL value passed to performOperation in GetListingPriceQuantityHelper",
					ex);
			throw ex;
		}
	}
}
