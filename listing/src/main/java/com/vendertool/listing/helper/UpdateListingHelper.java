package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingRequest;
import com.vendertool.sharedtypes.rnr.UpdateListingResponse;

public class UpdateListingHelper extends BaseListingHelper {

	private static final Logger logger = Logger
			.getLogger(UpdateListingHelper.class);

	private static class UpdateListingHelperHolder {
		private static final UpdateListingHelper INSTANCE = new UpdateListingHelper();
	}

	public static UpdateListingHelper getInstance() {
		return UpdateListingHelperHolder.INSTANCE;
	}

	private UpdateListingHelper() {
		super(ListingHelperTypeEnum.UPDATE_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in UpdateListingHelper");
			logger.debug(
					"NULL value passed to validate in UpdateListingHelper", ex);
			throw ex;
		}
		UpdateListingRequest updateListingRequest = (UpdateListingRequest) request;
		UpdateListingResponse updateListingResponse = (UpdateListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in UpdateListingHelper");
			logger.debug(
					"NULL value passed to performOperation in UpdateListingHelper",
					ex);
			throw ex;
		}
	}
}
