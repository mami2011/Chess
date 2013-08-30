package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetAuctionHighBidderRequest;
import com.vendertool.sharedtypes.rnr.GetAuctionHighBidderResponse;

public class GetAuctionHighBidderProcessor extends BaseListingProcessor {
	
	private static final Logger logger = Logger
			.getLogger(GetAuctionHighBidderProcessor.class);

	private static class GetAuctionHighBidderHelperHolder {
		private static final GetAuctionHighBidderProcessor INSTANCE = new GetAuctionHighBidderProcessor();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static GetAuctionHighBidderProcessor getInstance() {
		return GetAuctionHighBidderHelperHolder.INSTANCE;
	}

	private GetAuctionHighBidderProcessor() {
		super(ListingProcessorTypeEnum.GET_AUCTION_HIGH_BIDDER);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in GetAuctionHighBidderHelper");
			logger.debug("NULL value passed to validate in GetAuctionHighBidderHelper",
					ex);
			throw ex;
		}
		GetAuctionHighBidderRequest adjustListingQuantityRequest = (GetAuctionHighBidderRequest) request;
		GetAuctionHighBidderResponse adjustListingQuantityResponse = (GetAuctionHighBidderResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in GetAuctionHighBidderHelper");
			logger.debug("NULL value passed to performOperation in GetAuctionHighBidderHelper",
					ex);
			throw ex;
		}		
	}
}