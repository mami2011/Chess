package com.vendertool.inventory.dal.productVariation;

// Generated Aug 29, 2013 5:07:44 PM by Hibernate Tools 3.4.0.CR1

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
 * ProductVariation generated by hbm2java
 */
@Entity
@Table(name = "product_variation", catalog = "invdb")
public class ProductVariation implements java.io.Serializable {

	private Long productVariationId;
	private String title;
	private long productId;
	private Integer availbleQuantity;
	private BigDecimal price;
	private String url;
	private Date createdDate;
	private Date lastModifiedDate;

	public ProductVariation() {
		Date now = new Date();
		createdDate = now;
		lastModifiedDate = now;
	}

	public ProductVariation(long productId) {
		this.productId = productId;
	}

	public ProductVariation(String title, long productId,
			Integer availbleQuantity, BigDecimal price, String url,
			Date createdDate, Date lastModifiedDate) {
		this.title = title;
		this.productId = productId;
		this.availbleQuantity = availbleQuantity;
		this.price = price;
		this.url = url;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_variation_id", unique = true, nullable = false)
	public Long getProductVariationId() {
		return this.productVariationId;
	}

	public void setProductVariationId(Long productVariationId) {
		this.productVariationId = productVariationId;
	}

	@Column(name = "title", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "product_id", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Column(name = "availble_quantity")
	public Integer getAvailbleQuantity() {
		return this.availbleQuantity;
	}

	public void setAvailbleQuantity(Integer availbleQuantity) {
		this.availbleQuantity = availbleQuantity;
	}

	@Column(name = "price", precision = 18, scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "url", length = 4000)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
