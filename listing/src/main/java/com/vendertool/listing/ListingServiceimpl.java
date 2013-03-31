package com.vendertool.listing;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;

import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Listing;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

@Path("/listing")
public class ListingServiceimpl implements IListingService {

	@GET
	@ProduceMime({ "application/xml", "application/json" })
	public GetListingResponse getListing(@QueryParam("listingId") String id) {
		GetListingResponse response = new GetListingResponse();
		
		Product product = new Product("iPhone 4S");
		String pid = "P234567891";
		if(id == null) {
			id = pid;
		}
		product.setProductId(id);
		
		Listing listing = new Listing();
		listing.setProduct(product);
		listing.setPrice(new Amount(300));
		listing.setCondition("NEW");
		listing.setQuantity(3);
		
		response.setListing(listing);
		return response;
	}
	
	@POST
	@ConsumeMime({ "application/xml", "application/json" })
	@ProduceMime({ "application/xml", "application/json" })
	public AddListingResponse addListing(AddListingRequest request) {
		Listing listing = request.getListing();
		System.out.println("/listing/addlisting/ call. Adding listing ... " + listing.toString());
		
		AddListingResponse response = new AddListingResponse();
		response.setListingId("L987654321");
		
		return response;
	}

}
