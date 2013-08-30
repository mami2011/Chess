package com.vendertool.inventory.processor;

import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;


public abstract class BaseInventoryProcessor {

	public BaseInventoryProcessor(InventoryProcessorTypeEnum helperType) {
		this.processorType = helperType;
	}

	private InventoryProcessorTypeEnum processorType;

	public InventoryProcessorTypeEnum getProcessorType() {
		return processorType;
	}

	public void register() {
		InventoryProcessorRegistry.getInstance()
				.register(this.getProcessorType(), this);
	}

	public abstract void validate(BaseRequest request, BaseResponse response);

	public abstract void performOperation(BaseRequest request,
			BaseResponse response);
}