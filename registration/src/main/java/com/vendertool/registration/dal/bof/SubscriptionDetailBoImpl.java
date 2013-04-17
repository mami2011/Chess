package com.vendertool.registration.dal.bof;

import com.vendertool.registration.dal.dao.SubscriptionDetailDao;

public class SubscriptionDetailBoImpl implements SubscriptionDetailBo {
 
	SubscriptionDetailDao subscriptionDetailDao;
 
 public void setSubscriptionDetailDao(SubscriptionDetailDao subscriptionDetailDao) {
		this.subscriptionDetailDao = subscriptionDetailDao;
	}
	public void insert(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		subscriptionDetailDao.insert(subscriptionDetail);
	}

	public void update(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub

	}

	public void delete(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub

	}

	public SubscriptionDetail findByStockCode(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		subscriptionDetailDao.findByStockCode(subscriptionDetail);
		return null;
	}

}
