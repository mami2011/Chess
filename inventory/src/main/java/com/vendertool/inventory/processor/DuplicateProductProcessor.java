package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.DuplicateProductRequest;
import com.vendertool.sharedtypes.rnr.DuplicateProductResponse;

public class DuplicateProductProcessor  extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(AdjustProductQuantityProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();

	private static class DuplicateProductProcessorHolder {
		private static final DuplicateProductProcessor INSTANCE = new DuplicateProductProcessor();
	}

	public static DuplicateProductProcessor getInstance() {
		return DuplicateProductProcessorHolder.INSTANCE;
	}

	private DuplicateProductProcessor() {
		super(InventoryProcessorTypeEnum.DUPLICATE_PRODUCT);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in DuplicateProductProcessor");
			logger.debug(
					"NULL value passed to validate in DuplicateProductProcessor",
					ex);
			throw ex;
		}
		DuplicateProductRequest duplicateProductRequest = (DuplicateProductRequest) request;
		DuplicateProductResponse duplicateProductResponse = (DuplicateProductResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in DuplicateProductProcessor");
			logger.debug(
					"NULL value passed to performOperation in DuplicateProductProcessor",
					ex);
			throw ex;
		}
		DuplicateProductRequest duplicateProductRequest = (DuplicateProductRequest) request;
		DuplicateProductResponse duplicateProductResponse = (DuplicateProductResponse) response;

	}
}