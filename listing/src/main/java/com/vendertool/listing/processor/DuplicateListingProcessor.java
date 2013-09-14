package com.vendertool.listing.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.DuplicateListingRequest;
import com.vendertool.sharedtypes.rnr.DuplicateListingResponse;

public class DuplicateListingProcessor extends BaseListingProcessor {

	private static final Logger logger = Logger
			.getLogger(DuplicateListingProcessor.class);

	private static class DuplicateListingHelperHolder {
		private static final DuplicateListingProcessor INSTANCE = new DuplicateListingProcessor();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static DuplicateListingProcessor getInstance() {
		return DuplicateListingHelperHolder.INSTANCE;
	}

	private DuplicateListingProcessor() {
		super(ListingProcessorTypeEnum.DUPLICATE_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in DuplicateListingHelper");
			logger.debug(
					"NULL value passed to validate in DuplicateListingHelper",
					ex);
			throw ex;
		}
		DuplicateListingRequest verifyListingRequest = (DuplicateListingRequest) request;
		DuplicateListingResponse verifyListingResponse = (DuplicateListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in EndListingHelper");
			logger.debug(
					"NULL value passed to performOperation in EndListingHelper",
					ex);
			throw ex;
		}
	}
}