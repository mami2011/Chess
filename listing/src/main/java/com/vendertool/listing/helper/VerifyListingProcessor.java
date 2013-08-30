package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.VerifyListingRequest;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

public class VerifyListingProcessor extends BaseListingProcessor {
	
	private static final Logger logger = Logger
			.getLogger(AddListingProcessor.class);

	private static class VerifyListingHelperHolder {
		private static final VerifyListingProcessor INSTANCE = new VerifyListingProcessor();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static VerifyListingProcessor getInstance() {
		return VerifyListingHelperHolder.INSTANCE;
	}

	private VerifyListingProcessor() {
		super(ListingProcessorTypeEnum.VERIFY_LISTING);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in VerifyListingHelper");
			logger.debug("NULL value passed to validate in VerifyListingHelper",
					ex);
			throw ex;
		}
		VerifyListingRequest verifyListingRequest = (VerifyListingRequest) request;
		VerifyListingResponse verifyListingResponse = (VerifyListingResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in VerifyListingHelper");
			logger.debug("NULL value passed to performOperation in VerifyListingHelper",
					ex);
			throw ex;
		}		
	}
}