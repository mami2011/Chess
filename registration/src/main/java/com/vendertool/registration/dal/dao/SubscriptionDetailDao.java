package com.vendertool.registration.dal.dao;

import com.vendertool.registration.dal.bof.SubscriptionDetail;

public interface SubscriptionDetailDao {

	void insert (SubscriptionDetail subscriptionDetail);

	void update(SubscriptionDetail subscriptionDetail);

	void delete(SubscriptionDetail subscriptionDetail);

	SubscriptionDetail findByStockCode(SubscriptionDetail subscriptionDetail);
	
}
