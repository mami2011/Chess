package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.GetProductRequest;
import com.vendertool.sharedtypes.rnr.GetProductResponse;

public class GetProductProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(GetProductProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();
	private static class GetProductProcessorHolder {
		private static final GetProductProcessor INSTANCE = new GetProductProcessor();
	}

	public static GetProductProcessor getInstance() {
		return GetProductProcessorHolder.INSTANCE;
	}

	private GetProductProcessor() {
		super(InventoryProcessorTypeEnum.GET_PRODUCT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in GetProductProcessor");
			logger.debug("NULL value passed to validate in GetProductProcessor",
					ex);
			throw ex;
		}
		GetProductRequest getProductRequest = (GetProductRequest) request;
		GetProductResponse getProductResponse = (GetProductResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in GetProductProcessor");
			logger.debug("NULL value passed to performOperation in GetProductProcessor",
					ex);
			throw ex;
		}
		GetProductRequest getProductRequest = (GetProductRequest) request;
		GetProductResponse getProductResponse = (GetProductResponse) response;

	}
}