package com.vendertool.registration.dal.account;

import java.util.List;


public interface AccountDao {

	void insert (Account account);

	void update(Account account);

	void delete(Account account);

	List<Account> findByAccountId(long accountId);
	List<Account> findByEmailId(String emailId);
	
}
