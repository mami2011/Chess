package com.vendertool.sharedtypes.core;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Product implements Serializable {
	private static final long serialVersionUID = -5179393285196494207L;
	
	private String productId;
	private String title;
	
	public Product(){
	}
	
	public Product(String title){
		setTitle(title);
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title) {
		if((title == null) || (title.trim().length() <= 0)){
			throw new RuntimeException("invalid product title");
		}
		this.title = title;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String toString() {
		return "PRODUCT ID = '" + productId + "'; TITLE = '" + title + "'";
	}
}
