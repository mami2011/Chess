package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityRequest;
import com.vendertool.sharedtypes.rnr.AdjustProductQuantityResponse;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;

public class AdjustProductQuantityProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(AdjustProductQuantityProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();

	private static class AdjustProductQuantityProcessorHolder {
		private static final AdjustProductQuantityProcessor INSTANCE = new AdjustProductQuantityProcessor();
	}

	public static AdjustProductQuantityProcessor getInstance() {
		return AdjustProductQuantityProcessorHolder.INSTANCE;
	}

	private AdjustProductQuantityProcessor() {
		super(InventoryProcessorTypeEnum.ADJUST_PRODUCT_QTY);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in AdjustProductQuantityProcessor");
			logger.debug(
					"NULL value passed to validate in AdjustProductQuantityProcessor",
					ex);
			throw ex;
		}
		AdjustProductQuantityRequest removeProductRequest = (AdjustProductQuantityRequest) request;
		AdjustProductQuantityResponse removeProductResponse = (AdjustProductQuantityResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in AdjustProductQuantityProcessor");
			logger.debug(
					"NULL value passed to performOperation in AdjustProductQuantityProcessor",
					ex);
			throw ex;
		}
		AdjustProductQuantityRequest removeProductRequest = (AdjustProductQuantityRequest) request;
		AdjustProductQuantityResponse removeProductResponse = (AdjustProductQuantityResponse) response;

	}
}