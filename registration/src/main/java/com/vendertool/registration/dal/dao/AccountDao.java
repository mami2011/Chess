package com.vendertool.registration.dal.dao;

import com.vendertool.registration.dal.bof.Account;

public interface AccountDao {

	void insert (Account account);

	void update(Account account);

	void delete(Account account);

	Account findByStockCode(Account account);
	
}
