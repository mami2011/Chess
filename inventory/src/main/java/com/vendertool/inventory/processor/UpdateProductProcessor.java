package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductRequest;
import com.vendertool.sharedtypes.rnr.UpdateProductResponse;

public class UpdateProductProcessor  extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(UpdateProductProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();
	private static class UpdateProductProcessorHolder {
		private static final UpdateProductProcessor INSTANCE = new UpdateProductProcessor();
	}

	public static UpdateProductProcessor getInstance() {
		return UpdateProductProcessorHolder.INSTANCE;
	}

	private UpdateProductProcessor() {
		super(InventoryProcessorTypeEnum.UPDATE_PRODUCT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in UpdateProductProcessor");
			logger.debug("NULL value passed to validate in UpdateProductProcessor",
					ex);
			throw ex;
		}
		UpdateProductRequest updateProductRequest = (UpdateProductRequest) request;
		UpdateProductResponse addProductResponse = (UpdateProductResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in UpdateProductProcessor");
			logger.debug("NULL value passed to performOperation in UpdateProductProcessor",
					ex);
			throw ex;
		}
		UpdateProductRequest updateProductRequest = (UpdateProductRequest) request;
		UpdateProductResponse updateProductResponse = (UpdateProductResponse) response;

	}
}