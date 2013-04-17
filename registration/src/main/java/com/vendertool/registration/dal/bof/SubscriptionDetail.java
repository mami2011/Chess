package com.vendertool.registration.dal.bof;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

public class SubscriptionDetail implements Serializable {

	private int subscriptionId;
	private String subscriptionName;
	private int descriptionCode;
	private Date modifyDate;
	private String changeWho;
	private Date createDate;
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	public int getDescriptionCode() {
		return descriptionCode;
	}
	public void setDescriptionCode(int descriptionCode) {
		this.descriptionCode = descriptionCode;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getChangeWho() {
		return changeWho;
	}
	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
}
