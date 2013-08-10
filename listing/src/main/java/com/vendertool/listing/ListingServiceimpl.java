package com.vendertool.listing;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import com.vendertool.common.MarketCountryKey;
import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.mercadolibreadapter.IMarketListingAdapter;
import com.vendertool.sharedtypes.core.CountryEnum;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.MarketEnum;
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

@Path("/listing")
public class ListingServiceimpl extends BaseVenderToolServiceImpl 
	implements IListingService {
	

	@GET
	@Path("/getListing")
	@ProduceMime({ "application/xml", "application/json" })
	public GetListingResponse getListing(@QueryParam("listingId") String id) {
		CountryEnum countryId = CountryEnum.ALL;
		MarketEnum marketId = MarketEnum.MERCADO_LIBRE;
		
		IMarketListingAdapter adapter = ListingMarketAdapterRegistry.getInstance().getMarketListingAdapter(
				new MarketCountryKey(countryId, marketId));
		
		return adapter.getListing(id);
	}
	
	@POST
	@Path("/addListing")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddListingResponse addListing(AddListingRequest request) {
		Listing listing = request.getListing();
		IMarketListingAdapter adapter = ListingMarketAdapterRegistry.getInstance().getMarketListingAdapter(
				new MarketCountryKey(listing.getCountry(), listing.getMarket()));
		adapter.addListing(request);
				
		AddListingResponse response = new AddListingResponse();
		response.setListingId("L987654321");
		
		return response;
	}

	@GET
	@Path("/getListingPriceQuantity")
	@ProduceMime({ "application/xml", "application/json" })
	public GetListingPriceQuantityResponse getListingPriceQuantity(
			@QueryParam("listingId") String listingId) {
		return null;
	}

	@GET
	@Path("/endListing")
	@ProduceMime({ "application/xml", "application/json" })
	public EndListingResponse endListing(@QueryParam("listingId") String listingId) {
		return null;
	}

	@POST
	@Path("/updateListing")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public UpdateListingResponse updateListing(UpdateListingRequest request) {
		return null;
	}

	@POST
	@Path("/updateListingPriceQuantity")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public UpdateListingPriceQuanityResponse updateListingPriceQuantity(
			UpdateListingPriceQuantityRequest request) {
		return null;
	}

	@POST
	@Path("/adjustListingQuantity")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AdjustListingQuantityResponse adjustListingQuantity(
			AdjustListingQuantityRequest request) {
		return null;
	}

	@GET
	@Path("/duplicateListing")
	@ProduceMime({ "application/xml", "application/json" })
	public DuplicateListingResponse duplicateListing(@QueryParam("listingId") String listingId) {
		return null;
	}

	@GET
	@Path("/getAuctionBidCount")
	@ProduceMime({ "application/xml", "application/json" })
	public GetAuctionBidCountResponse getAuctionBidCount(@QueryParam("listingId") String listingId) {
		return null;
	}

	@GET
	@Path("/getAuctionHighBidder")
	@ProduceMime({ "application/xml", "application/json" })
	public GetAuctionHighBidderResponse getAuctionHighBidder(@QueryParam("listingId") String listingId) {
		return null;
	}

	@POST
	@Path("/verifyListing")
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public VerifyListingResponse verifyListing(VerifyListingRequest request) {
		return null;
	}
}
