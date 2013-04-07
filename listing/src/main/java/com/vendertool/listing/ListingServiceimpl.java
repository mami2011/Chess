package com.vendertool.listing;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

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

@Path("/${project.version}/listing")
public class ListingServiceimpl extends BaseVenderToolServiceImpl 
	implements IListingService {
	

	@GET
	@ProduceMime({ "application/xml", "application/json" })
	public GetListingResponse getListing(@QueryParam("listingId") String id) {
//		GetListingResponse response = new GetListingResponse();
//		
//		Product product = new Product("iPhone 4S");
//		String pid = "P234567891";
//		if(id == null) {
//			id = pid;
//		}
//		product.setProductId(id);
//		
//		Listing listing = new Listing();
//		listing.setProduct(product);
//		listing.setPrice(new Amount(300));
//		listing.setCondition("NEW");
//		listing.setQuantity(3);
//		
//		response.setListing(listing);
//		return response;
		CountryEnum countryId = CountryEnum.BRAZIL;
		MarketEnum marketId = MarketEnum.MERCADO_LIBRE;
		String marketListingId = "MLA449467442";
		
		IMarketListingAdapter adapter = MarketListingRegistry.getInstance().getMarketListingAdapter(
				new MarketCountryKey(countryId, marketId));
		adapter.getListing(marketListingId);
		
		return null;
	}
	
	@POST
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddListingResponse addListing(AddListingRequest request) {
		Listing listing = request.getListing();
		IMarketListingAdapter adapter = MarketListingRegistry.getInstance().getMarketListingAdapter(
				new MarketCountryKey(listing.getCountry(), listing.getMarket()));
		adapter.addListing(request);
				
		AddListingResponse response = new AddListingResponse();
		response.setListingId("L987654321");
		
		return response;
	}

	public GetListingPriceQuantityResponse getListingPriceQuantity(
			String listingId) {
		return null;
	}

	public EndListingResponse endListing(String listingId) {
		return null;
	}

	public UpdateListingResponse updateListing(UpdateListingRequest request) {
		return null;
	}

	public UpdateListingPriceQuanityResponse updateListingPriceQuantity(
			UpdateListingPriceQuantityRequest request) {
		return null;
	}

	public AdjustListingQuantityResponse adjustListingQuantity(
			AdjustListingQuantityRequest request) {
		return null;
	}

	public DuplicateListingResponse duplicateListing(String listingId) {
		return null;
	}

	public GetAuctionBidCountResponse getAuctionBidCount(String listingId) {
		return null;
	}

	public GetAuctionHighBidderResponse getAuctionHighBidder(String listingId) {
		return null;
	}

	public VerifyListingResponse verifyListing(VerifyListingRequest request) {
		return null;
	}
}
