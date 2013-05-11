package dal.dao;

// Generated May 10, 2013 11:09:53 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Listing generated by hbm2java
 */
@Entity
@Table(name = "listing", catalog = "stool")
public class Listing implements java.io.Serializable {

	private int listingId;
	private String title;
	private Integer shippingPolicyId;
	private Integer returnPolicyId;
	private Integer paymentPolicyId;
	private Integer locationPolicyId;
	private BigDecimal price;
	private Integer quantity;
	private Integer clasificationId;
	private String produce;
	private Date modifiedDate;
	private String changeWho;
	private Date createDate;

	public Listing() {
	}

	public Listing(int listingId) {
		this.listingId = listingId;
	}

	public Listing(int listingId, String title, Integer shippingPolicyId,
			Integer returnPolicyId, Integer paymentPolicyId,
			Integer locationPolicyId, BigDecimal price, Integer quantity,
			Integer clasificationId, String produce, Date modifiedDate,
			String changeWho, Date createDate) {
		this.listingId = listingId;
		this.title = title;
		this.shippingPolicyId = shippingPolicyId;
		this.returnPolicyId = returnPolicyId;
		this.paymentPolicyId = paymentPolicyId;
		this.locationPolicyId = locationPolicyId;
		this.price = price;
		this.quantity = quantity;
		this.clasificationId = clasificationId;
		this.produce = produce;
		this.modifiedDate = modifiedDate;
		this.changeWho = changeWho;
		this.createDate = createDate;
	}

	@Id
	@Column(name = "LISTING_ID", unique = true, nullable = false)
	public int getListingId() {
		return this.listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	@Column(name = "TITLE", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "SHIPPING_POLICY_ID")
	public Integer getShippingPolicyId() {
		return this.shippingPolicyId;
	}

	public void setShippingPolicyId(Integer shippingPolicyId) {
		this.shippingPolicyId = shippingPolicyId;
	}

	@Column(name = "RETURN_POLICY_ID")
	public Integer getReturnPolicyId() {
		return this.returnPolicyId;
	}

	public void setReturnPolicyId(Integer returnPolicyId) {
		this.returnPolicyId = returnPolicyId;
	}

	@Column(name = "PAYMENT_POLICY_ID")
	public Integer getPaymentPolicyId() {
		return this.paymentPolicyId;
	}

	public void setPaymentPolicyId(Integer paymentPolicyId) {
		this.paymentPolicyId = paymentPolicyId;
	}

	@Column(name = "LOCATION_POLICY_ID")
	public Integer getLocationPolicyId() {
		return this.locationPolicyId;
	}

	public void setLocationPolicyId(Integer locationPolicyId) {
		this.locationPolicyId = locationPolicyId;
	}

	@Column(name = "PRICE", scale = 4)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "CLASIFICATION_ID")
	public Integer getClasificationId() {
		return this.clasificationId;
	}

	public void setClasificationId(Integer clasificationId) {
		this.clasificationId = clasificationId;
	}

	@Column(name = "PRODUCE", length = 45)
	public String getProduce() {
		return this.produce;
	}

	public void setProduce(String produce) {
		this.produce = produce;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", length = 19)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "CHANGE_WHO", length = 45)
	public String getChangeWho() {
		return this.changeWho;
	}

	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
