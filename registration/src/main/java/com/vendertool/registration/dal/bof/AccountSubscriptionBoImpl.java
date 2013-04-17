package com.vendertool.registration.dal.bof;

import com.vendertool.registration.dal.dao.AccountSubscriptionDao;

public class AccountSubscriptionBoImpl implements AccountSubscriptionBo {
 
	AccountSubscriptionDao accountSubscriptionDao;
 
 public void setAccountSubscriptionDao(AccountSubscriptionDao accountSubscriptionDao) {
		this.accountSubscriptionDao = accountSubscriptionDao;
	}
	public void insert(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		accountSubscriptionDao.insert(accountSubscription);
	}

	public void update(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub

	}

	public void delete(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub

	}

	public AccountSubscription findByStockCode(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		accountSubscriptionDao.findByStockCode(accountSubscription);
		return null;
	}

}
