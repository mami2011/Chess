package com.vendertool.listing;

import com.vendertool.sharedtypes.rnr.AddListingRequest;
import com.vendertool.sharedtypes.rnr.AddListingResponse;
import com.vendertool.sharedtypes.rnr.GetListingRequest;
import com.vendertool.sharedtypes.rnr.GetListingResponse;

public interface IListingService {
	public AddListingResponse addListing(AddListingRequest request);
	
	public GetListingResponse getListing(String id);
}
