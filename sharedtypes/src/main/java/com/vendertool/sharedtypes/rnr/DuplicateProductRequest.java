package com.vendertool.sharedtypes.rnr;

public class DuplicateProductRequest extends BaseRequest {

	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}