package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.AdjustListingQuantityRequest;
import com.vendertool.sharedtypes.rnr.AdjustListingQuantityResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class AdjustListingQuantityHelper extends BaseListingHelper {
	
	private static final Logger logger = Logger
			.getLogger(AdjustListingQuantityHelper.class);

	private static class AdjustListingQuantityHelperHolder {
		private static final AdjustListingQuantityHelper INSTANCE = new AdjustListingQuantityHelper();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static AdjustListingQuantityHelper getInstance() {
		return AdjustListingQuantityHelperHolder.INSTANCE;
	}

	private AdjustListingQuantityHelper() {
		super(ListingHelperTypeEnum.ADJUST_LISTING_QUANTITY);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in AdjustListingQuantityHelper");
			logger.debug("NULL value passed to validate in AdjustListingQuantityHelper",
					ex);
			throw ex;
		}
		AdjustListingQuantityRequest adjustListingQuantityRequest = (AdjustListingQuantityRequest) request;
		AdjustListingQuantityResponse adjustListingQuantityResponse = (AdjustListingQuantityResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in AdjustListingQuantityHelper");
			logger.debug("NULL value passed to performOperation in AdjustListingQuantityHelper",
					ex);
			throw ex;
		}		
	}
}