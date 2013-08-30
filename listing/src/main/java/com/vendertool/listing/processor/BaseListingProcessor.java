package com.vendertool.listing.processor;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public abstract class BaseListingProcessor {

	public BaseListingProcessor(ListingProcessorTypeEnum helperType) {
		this.processorType = helperType;
	}

	private ListingProcessorTypeEnum processorType;

	public ListingProcessorTypeEnum getProcessorType() {
		return processorType;
	}

	public void register() {
		ListingProcessorRegistry.getInstance()
				.register(this.getProcessorType(), this);
	}

	public abstract void validate(BaseRequest request, BaseResponse response);

	public abstract void performOperation(BaseRequest request,
			BaseResponse response);
}