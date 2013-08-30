package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.RemoveProductRequest;
import com.vendertool.sharedtypes.rnr.RemoveProductResponse;

public class RemoveProductProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(RemoveProductProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();
	private static class RemoveProductProcessorHolder {
		private static final RemoveProductProcessor INSTANCE = new RemoveProductProcessor();
	}

	public static RemoveProductProcessor getInstance() {
		return RemoveProductProcessorHolder.INSTANCE;
	}

	private RemoveProductProcessor() {
		super(InventoryProcessorTypeEnum.REMOVE_PRODUCT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in RemoveProductProcessor");
			logger.debug("NULL value passed to validate in RemoveProductProcessor",
					ex);
			throw ex;
		}
		RemoveProductRequest removeProductRequest = (RemoveProductRequest) request;
		RemoveProductResponse removeProductResponse = (RemoveProductResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in RemoveProductProcessor");
			logger.debug("NULL value passed to performOperation in RemoveProductProcessor",
					ex);
			throw ex;
		}
		RemoveProductRequest removeProductRequest = (RemoveProductRequest) request;
		RemoveProductResponse removeProductResponse = (RemoveProductResponse) response;

	}
}