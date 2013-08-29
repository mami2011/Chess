package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetAuctionHighBidderRequest;
import com.vendertool.sharedtypes.rnr.GetAuctionHighBidderResponse;

public class GetAuctionHighBidderHelper extends BaseListingHelper {
	
	private static final Logger logger = Logger
			.getLogger(GetAuctionHighBidderHelper.class);

	private static class GetAuctionHighBidderHelperHolder {
		private static final GetAuctionHighBidderHelper INSTANCE = new GetAuctionHighBidderHelper();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static GetAuctionHighBidderHelper getInstance() {
		return GetAuctionHighBidderHelperHolder.INSTANCE;
	}

	private GetAuctionHighBidderHelper() {
		super(ListingHelperTypeEnum.GET_AUCTION_HIGH_BIDDER);
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