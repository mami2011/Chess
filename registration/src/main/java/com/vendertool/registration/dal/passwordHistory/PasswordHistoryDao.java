package com.vendertool.registration.dal.passwordHistory;

import java.util.List;



public interface PasswordHistoryDao {

	void insert (PasswordHistory passwordHistory);
	
	void update(PasswordHistory passwordHistory);

	void delete(PasswordHistory passwordHistory);

	List <PasswordHistory> findByAccountId(Long accountId);
	
}
