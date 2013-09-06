package com.vendertool.inventory.processor;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuanityResponse;
import com.vendertool.sharedtypes.rnr.UpdateProductPriceQuantityRequest;

public class UpdateProductPriceQuantityProcessor extends BaseInventoryProcessor {

	private static final Logger logger = Logger
			.getLogger(UpdateProductPriceQuantityProcessor.class);
	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();
	private static class UpdateProductPriceQuantityProcessorHolder {
		private static final UpdateProductPriceQuantityProcessor INSTANCE = new UpdateProductPriceQuantityProcessor();
	}

	public static UpdateProductPriceQuantityProcessor getInstance() {
		return UpdateProductPriceQuantityProcessorHolder.INSTANCE;
	}

	private UpdateProductPriceQuantityProcessor() {
		super(InventoryProcessorTypeEnum.UPDATE_PRODUCT_PRICE_QTY);
	}

	@Override
	public void validate(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in UpdateProductPriceQuantityProcessor");
			logger.debug("NULL value passed to validate in UpdateProductPriceQuantityProcessor",
					ex);
			throw ex;
		}
		UpdateProductPriceQuantityRequest updateProductPriceQuantityRequest = (UpdateProductPriceQuantityRequest) request;
		UpdateProductPriceQuanityResponse updateProductPriceQuanityResponse = (UpdateProductPriceQuanityResponse) response;

	}

	@Override
	public void performOperation(BaseRequest request, BaseResponse response) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to performOperation in UpdateProductPriceQuantityProcessor");
			logger.debug("NULL value passed to performOperation in UpdateProductPriceQuantityProcessor",
					ex);
			throw ex;
		}
		UpdateProductPriceQuantityRequest removeProductRequest = (UpdateProductPriceQuantityRequest) request;
		UpdateProductPriceQuanityResponse updateProductPriceQuanityResponse = (UpdateProductPriceQuanityResponse) response;

	}
}