package com.vendertool.sharedtypes.rnr;

public class EndListingRequest extends BaseRequest {
	private String listingId;

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
}