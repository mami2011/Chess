package com.vendertool.registration.dal.bof;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

public class AccountSubscription implements Serializable {

	private int accountSubscriptionId;
	private int accountIdId;
	private int subscriptionId;
	private int subscriptionType;
	private Date startDate;
	private Date endDate;
	public int getAccountSubscriptionId() {
		return accountSubscriptionId;
	}
	public void setAccountSubscriptionId(int accountSubscriptionId) {
		this.accountSubscriptionId = accountSubscriptionId;
	}
	public int getAccountIdId() {
		return accountIdId;
	}
	public void setAccountIdId(int accountIdId) {
		this.accountIdId = accountIdId;
	}
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public int getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(int subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
