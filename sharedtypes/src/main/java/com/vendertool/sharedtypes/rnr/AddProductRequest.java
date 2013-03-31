package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Product;

@XmlRootElement
public class AddProductRequest extends BaseRequest{
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
