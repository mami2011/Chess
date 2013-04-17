package com.vendertool.registration.dal.bof;

public interface AccountSubscriptionBo {

	void insert(AccountSubscription accountSubscription);

	void update(AccountSubscription accountSubscription);

	void delete(AccountSubscription accountSubscription);

	AccountSubscription findByStockCode(AccountSubscription accountSubscription);
	
}
