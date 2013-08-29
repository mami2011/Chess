package com.vendertool.listing.helper;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetAuctionBidCountRequest;
import com.vendertool.sharedtypes.rnr.GetAuctionBidCountResponse;

public class GetAuctionBidCountHelper extends BaseListingHelper {
	
	private static final Logger logger = Logger
			.getLogger(GetAuctionBidCountHelper.class);

	private static class GetAuctionBidCountHelperHolder {
		private static final GetAuctionBidCountHelper INSTANCE = new GetAuctionBidCountHelper();
	}

	/**
	 * Get the singleton instance of the class
	 * 
	 * @return
	 */
	public static GetAuctionBidCountHelper getInstance() {
		return GetAuctionBidCountHelperHolder.INSTANCE;
	}

	private GetAuctionBidCountHelper() {
		super(ListingHelperTypeEnum.GET_AUCTION_BID_COUNT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in GetAuctionBidCountHelper");
			logger.debug("NULL value passed to validate in GetAuctionBidCountHelper",
					ex);
			throw ex;
		}
		GetAuctionBidCountRequest adjustListingQuantityRequest = (GetAuctionBidCountRequest) request;
		GetAuctionBidCountResponse adjustListingQuantityResponse = (GetAuctionBidCountResponse) response;

		// TODO start basic validation
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (request == null || response == null) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in GetAuctionBidCountHelper");
			logger.debug("NULL value passed to performOperation in GetAuctionBidCountHelper",
					ex);
			throw ex;
		}		
	}
}