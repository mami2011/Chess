package com.vendertool.listing.processor;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.EndListingRequest;
import com.vendertool.sharedtypes.rnr.EndListingResponse;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

public class EndListingProcessor extends BaseListingProcessor {
	
	private static final Logger logger = Logger
			.getLogger(EndListingProcessor.class);

	private static class EndListingHelperHolder {
		private static final EndListingProcessor INSTANCE = new EndListingProcessor();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static EndListingProcessor getInstance() {
		return EndListingHelperHolder.INSTANCE;
	}

	private EndListingProcessor() {
		super(ListingProcessorTypeEnum.END_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in EndListingHelper");
			logger.debug("NULL value passed to validate in EndListingHelper",
					ex);
			throw ex;
		}
		EndListingRequest verifyListingRequest = (EndListingRequest) request;
		EndListingResponse verifyListingResponse = (EndListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in EndListingHelper");
			logger.debug("NULL value passed to performOperation in EndListingHelper",
					ex);
			throw ex;
		}		
	}
}