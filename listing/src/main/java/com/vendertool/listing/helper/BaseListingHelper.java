package com.vendertool.listing.helper;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public abstract class BaseListingHelper {

	public BaseListingHelper(ListingHelperTypeEnum helperType) {
		this.helperType = helperType;
	}

	private ListingHelperTypeEnum helperType;

	public ListingHelperTypeEnum getHelperType() {
		return helperType;
	}

	public void register() {
		ListingHelperRegistry.getInstance()
				.register(this.getHelperType(), this);
	}

	public abstract void validate(BaseRequest request, BaseResponse response);

	public abstract void performOperation(BaseRequest request,
			BaseResponse response);
}