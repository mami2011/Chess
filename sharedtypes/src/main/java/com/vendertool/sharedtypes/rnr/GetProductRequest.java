package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GetProductRequest {
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
