package com.vendertool.listing.helper;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public abstract class BaseListingProcessor {

	public BaseListingProcessor(ListingProcessorTypeEnum helperType) {
		this.helperType = helperType;
	}

	private ListingProcessorTypeEnum helperType;

	public ListingProcessorTypeEnum getHelperType() {
		return helperType;
	}

	public void register() {
		ListingProcessorRegistry.getInstance()
				.register(this.getHelperType(), this);
	}

	public abstract void validate(BaseRequest request, BaseResponse response);

	public abstract void performOperation(BaseRequest request,
			BaseResponse response);
}