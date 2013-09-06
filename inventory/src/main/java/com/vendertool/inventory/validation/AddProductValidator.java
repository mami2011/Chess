package com.vendertool.inventory.validation;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.core.Amount;
import com.vendertool.sharedtypes.core.Product;
import com.vendertool.sharedtypes.core.ProductCodeTypeEnum;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.AddProductRequest;
import com.vendertool.sharedtypes.rnr.AddProductResponse;

public class AddProductValidator {

	private static ValidationUtil s_validationUtil = ValidationUtil
			.getInstance();
	private static final Logger logger = Logger
			.getLogger(AddProductValidator.class);

	private static class AddProductValidatorHolder {
		private static AddProductValidator INSTANCE = new AddProductValidator();
	}

	private AddProductValidator() {

	}

	public static AddProductValidator getInstance() {
		return AddProductValidatorHolder.INSTANCE;
	}

	public void validate(AddProductResponse response, AddProductRequest request) {
		if (s_validationUtil.isNull(request)
				|| s_validationUtil.isNull(response)) {
			VTRuntimeException ex = new VTRuntimeException(
					"NULL value passed to validate in AddProductProcessor");
			logger.debug(
					"NULL value passed to validate in AddProductProcessor", ex);
			throw ex;
		}

		Product product = request.getProduct();
		if (s_validationUtil.isNull(product)) {
			response.addFieldBindingError(
					Errors.LISTING.LISTING_CONTAINER_IS_EMPTY, request
							.getClass().getName(), "addProductRequest");
			// If am here, I don't have anything to process. So am going back.
			return;
		}
		// Now add all errors and return if there are any.
		String title = product.getTitle();
		if (s_validationUtil.isEmpty(title)) {
			response.addFieldBindingError(
					Errors.INVENTORY.MISSING_TITLE, product
							.getClass().getName(), "title");
		}

		Amount price = product.getPrice();
		if (s_validationUtil.isNull(price)) {
			response.addFieldBindingError(
					Errors.INVENTORY.MISSING_PRICE, product
							.getClass().getName(), "price");
		}

		String sku = product.getSku();
		if (s_validationUtil.isEmpty(sku)) {
			response.addFieldBindingError(
					Errors.INVENTORY.MISSING_SKU, product
							.getClass().getName(), "Sku");
		}
		
		String productCode = product.getProductCode();
		if (s_validationUtil.isEmpty(productCode)) {
			response.addFieldBindingError(
					Errors.INVENTORY.MISSING_PRODUCT_CODE, product
							.getClass().getName(), "productCode");
		}

		ProductCodeTypeEnum productCodetype = product.getProductCodeType();
		if (s_validationUtil.isNull(productCodetype)) {
			response.addFieldBindingError(
					Errors.INVENTORY.MISSING_PRODUCT_CODE_TYPE, product
							.getClass().getName(), "productCodeType");
		}
		
		int qty = product.getQuantity();
		if (!s_validationUtil.isPositiveInteger(qty)) {
			response.addFieldBindingError(
					Errors.INVENTORY.INVALID_QUANTITY, product
							.getClass().getName(), "quantity");
		}
	}
}