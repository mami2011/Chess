package com.vendertool.inventory.DBL;

import java.io.Serializable;
import java.util.Currency;

public class MerchantProduct implements Serializable {
	private int productId;
	private String productTitle;
	private int descriptionId;
	private String productName;
	private String productSKU;
	private String productType;
	private String productCode;
	private String productURL;
	private int availableQuantity;
	private Currency productCost;
	private String changeWho;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public int getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSKU() {
		return productSKU;
	}
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Currency getProductCost() {
		return productCost;
	}
	public void setProductCost(Currency productCost) {
		this.productCost = productCost;
	}
	public String getChangeWho() {
		return changeWho;
	}
	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}
	
}
