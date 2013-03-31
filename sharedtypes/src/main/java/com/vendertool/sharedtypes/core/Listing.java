package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name="Listing")
public class Listing {
	private String listingId;
	private Product product;
	private Amount price;
	private int quantity;
	private String condition;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Amount getPrice() {
		return price;
	}
	public void setPrice(Amount price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	
	public String toString() {
		return "LISTING ID = '" + getListingId() + "' \n PRODUCT = [" + getProduct().toString() + "]\n"
				+ "CONDITION = '" + getCondition() + "' QUANTITY = '" + getQuantity() + 
				"' PRICE = '" + ((getPrice() != null) ? getPrice().getValueFormat() : 0) + "'";
	}
}
