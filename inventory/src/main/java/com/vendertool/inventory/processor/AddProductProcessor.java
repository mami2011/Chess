package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class AddProductProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(AddProductProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
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
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in AddProductProcessor");
			logger.debug("NULL value passed to validate in AddProductProcessor",
					ex);
			throw ex;
		}
		AddProductRequest addProductRequest = (AddProductRequest) request;
		AddProductResponse addProductResponse = (AddProductResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in AddProductProcessor");
			logger.debug("NULL value passed to performOperation in AddProductProcessor",
					ex);
			throw ex;
		}
		AddProductRequest addProductRequest = (AddProductRequest) request;
		AddProductResponse addProductResponse = (AddProductResponse) response;

	}
}
