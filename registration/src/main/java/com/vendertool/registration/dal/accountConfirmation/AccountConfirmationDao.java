package com.vendertool.registration.dal.accountConfirmation;

import java.util.List;


public interface AccountConfirmationDao {

	void insert (AccountConfirmation accountConfirmation);

	void update(AccountConfirmation accountConfirmation);

	void delete(AccountConfirmation accountConfirmation);

	List<AccountConfirmation> findByAccountId(Long accountId);
	
}
