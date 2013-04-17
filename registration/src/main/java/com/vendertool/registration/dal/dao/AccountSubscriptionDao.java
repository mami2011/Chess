package com.vendertool.registration.dal.dao;

import com.vendertool.registration.dal.bof.AccountSubscription;

public interface AccountSubscriptionDao {

	void insert (AccountSubscription accountSubscription);

	void update(AccountSubscription accountSubscription);

	void delete(AccountSubscription accountSubscription);

	AccountSubscription findByStockCode(AccountSubscription accountSubscription);
	
}
