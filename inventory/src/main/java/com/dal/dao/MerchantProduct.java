package com.dal.dao;

// Generated May 17, 2013 11:06:45 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MerchantProduct generated by hbm2java
 */
@Entity
@Table(name = "merchant_product", catalog = "PRODUCTDB")
public class MerchantProduct implements java.io.Serializable {

	private Long merchantProductId;
	private String title;
	private String sku;
	private Long accountId;
	private String productCode;
	private Byte productCodeType;
	private Integer availableQuantity;
	private BigDecimal price;
	private Date createdDate;
	private Date lastModifiedDate;
	private Byte lastModifiedApp;

	public MerchantProduct() {
	}

	public MerchantProduct(String title, String sku, Long accountId,
			String productCode, Byte productCodeType,
			Integer availableQuantity, BigDecimal price, Date createdDate,
			Date lastModifiedDate, Byte lastModifiedApp) {
		this.title = title;
		this.sku = sku;
		this.accountId = accountId;
		this.productCode = productCode;
		this.productCodeType = productCodeType;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedApp = lastModifiedApp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MERCHANT_PRODUCT_ID", unique = true, nullable = false)
	public Long getMerchantProductId() {
		return this.merchantProductId;
	}

	public void setMerchantProductId(Long merchantProductId) {
		this.merchantProductId = merchantProductId;
	}

	@Column(name = "TITLE", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "SKU", length = 64)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "ACCOUNT_ID")
	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "PRODUCT_CODE", length = 64)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "PRODUCT_CODE_TYPE")
	public Byte getProductCodeType() {
		return this.productCodeType;
	}

	public void setProductCodeType(Byte productCodeType) {
		this.productCodeType = productCodeType;
	}

	@Column(name = "AVAILABLE_QUANTITY")
	public Integer getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name = "PRICE", precision = 18, scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "LAST_MODIFIED_APP")
	public Byte getLastModifiedApp() {
		return this.lastModifiedApp;
	}

	public void setLastModifiedApp(Byte lastModifiedApp) {
		this.lastModifiedApp = lastModifiedApp;
	}

}
