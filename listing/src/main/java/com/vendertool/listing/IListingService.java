package com.vendertool.listing;

import com.vendertool.common.service.IVenderToolService;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.AdjustListingQuantityRequest;
import com.vendertool.sharedtypes.rnr.AdjustListingQuantityResponse;
import com.vendertool.sharedtypes.rnr.DuplicateListingResponse;
import com.vendertool.sharedtypes.rnr.EndListingResponse;
import com.vendertool.sharedtypes.rnr.GetAuctionBidCountResponse;
import com.vendertool.sharedtypes.rnr.GetAuctionHighBidderResponse;
import com.vendertool.sharedtypes.rnr.GetListingPriceQuantityResponse;
import com.vendertool.sharedtypes.rnr.GetListingResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingPriceQuanityResponse;
import com.vendertool.sharedtypes.rnr.UpdateListingPriceQuantityRequest;
import com.vendertool.sharedtypes.rnr.UpdateListingRequest;
import com.vendertool.sharedtypes.rnr.UpdateListingResponse;
import com.vendertool.sharedtypes.rnr.VerifyListingRequest;
import com.vendertool.sharedtypes.rnr.VerifyListingResponse;

public interface IListingService extends IVenderToolService {
	/**
	 * HTTP POST call to add a listing to a market
	 * 
	 * @param request
	 * @return
	 */
	public AddListingResponse addListing(AddListingRequest request);
	
	/**
	 * HTTP POST to verify listings
	 * @param request
	 * @return
	 */
	public VerifyListingResponse verifyListing(VerifyListingRequest request);
	
	/**
	 * HTTP GET call to get the listing
	 * 
	 * @param id
	 * @return
	 */
	public GetListingResponse getListing(String id);
	
	/**
	 * HTTP GET call to get the price and quantity of an existing listing
	 * 
	 * @param listingId
	 * @return
	 */
	public GetListingPriceQuantityResponse getListingPriceQuantity(String listingId);
	
	/**
	 * HTTP GET call to end the listing
	 * 
	 * @param listingId
	 * @return
	 */
	public EndListingResponse endListing(String listingId);
	
	/**
	 * HTTP POST call to update the listing
	 * 
	 * @param request
	 * @return
	 */
	public UpdateListingResponse updateListing(UpdateListingRequest request);
	
	/**
	 * HTTP POST call to update the price and quantity
	 * 
	 * @param request
	 * @return
	 */
	public UpdateListingPriceQuanityResponse updateListingPriceQuantity(UpdateListingPriceQuantityRequest request);
	
	/**
	 * HTTP POST call to increment or decrement the listing quantity
	 * 
	 * @param request
	 * @return
	 */
	public AdjustListingQuantityResponse adjustListingQuantity(AdjustListingQuantityRequest request);
	
	/**
	 * HTTP GET call to duplicate and create a new listing
	 * 
	 * @param request
	 * @return
	 */
	public DuplicateListingResponse duplicateListing(String listingId);
	
	/**
	 * HTTP GET call to get the listing view count
	 * 
	 * @param listingId
	 * @return
	 */
	public GetAuctionBidCountResponse getAuctionBidCount(String listingId);
	
	/**
	 * HTTP GET call to get the auction high bidder
	 * 
	 * @param listingId
	 * @return
	 */
	public GetAuctionHighBidderResponse getAuctionHighBidder(String listingId);
}
