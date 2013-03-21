package com.vendertool.common.types.rnr;

import com.vendertool.common.types.MerchantProduct;

public class CreateProductRequest extends BaseRequest {
	MerchantProduct product;

	public MerchantProduct getProduct() {
		return product;
	}

	public void setProduct(MerchantProduct product) {
		this.product = product;
	}
	
}
