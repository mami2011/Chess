package com.vendertool.registration.dal.bof;

public interface SubscriptionDetailBo {

	void insert(SubscriptionDetail subscriptionDetail);

	void update(SubscriptionDetail subscriptionDetail);

	void delete(SubscriptionDetail subscriptionDetail);

	SubscriptionDetail findByStockCode(SubscriptionDetail subscriptionDetail);
	
}
