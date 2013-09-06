package com.vendertool.sharedtypes.rnr;

public class GetProductVariationRequest extends BaseRequest {
	private String productId;
	private String variationId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVariationId() {
		return variationId;
	}

	public void setVariationId(String variationId) {
		this.variationId = variationId;
	}
}