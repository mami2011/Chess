package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

public class GetListingHelper  extends BaseListingHelper {

	private static final Logger logger = Logger
			.getLogger(GetListingHelper.class);

	private static class GetListingHelperHolder {
		private static final GetListingHelper INSTANCE = new GetListingHelper();
	}

	public static GetListingHelper getInstance() {
		return GetListingHelperHolder.INSTANCE;
	}

	private GetListingHelper() {
		super(ListingHelperTypeEnum.GET_LISTING);
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
	}
}