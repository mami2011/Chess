package com.vendertool.registration.dal.bof;

import com.vendertool.registration.dal.dao.AccountDao;

public class AccountBoImpl implements AccountBo {
 
	AccountDao accountDao;
 
 public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void insert(Account account) {
		// TODO Auto-generated method stub
		accountDao.insert(account);
	}

	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	public void delete(Account account) {
		// TODO Auto-generated method stub

	}

	public Address findByStockCode(Account account) {
		// TODO Auto-generated method stub
		accountDao.findByStockCode(account);
		return null;
	}

}
