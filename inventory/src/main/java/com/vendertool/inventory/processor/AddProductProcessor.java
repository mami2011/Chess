package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.inventory.validation.AddProductValidator;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class AddProductProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(AddProductProcessor.class);
	private static AddProductValidator s_validator = AddProductValidator
			.getInstance();

	private static class AddProductProcessorHolder {
		private static final AddProductProcessor INSTANCE = new AddProductProcessor();
	}

	public static AddProductProcessor getInstance() {
		return AddProductProcessorHolder.INSTANCE;
	}

	private AddProductProcessor() {
		super(InventoryProcessorTypeEnum.ADD_PRODUCT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		s_validator.validate((AddProductResponse) response,
				(AddProductRequest) request);
	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		AddProductRequest addProductRequest = (AddProductRequest) request;
		AddProductResponse addProductResponse = (AddProductResponse) response;
		Product product = addProductRequest.getProduct();
//		ProductBof.getInstance().insert(product);
	}
}