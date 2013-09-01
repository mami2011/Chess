package com.vendertool.registration.dal.account.deprecate;

import java.util.List;

import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;


public interface AccountDao {

	void insert (Account account) throws DBConnectionException, InsertException;

	void update(Account account) throws DBConnectionException, UpdateException;

	void delete(Account account) throws DBConnectionException, DeleteException;

	List<Account> findByAccountId(Long accountId) throws DBConnectionException, FinderException;
	List<Account> findByEmailId(String emailId) throws DBConnectionException, FinderException;
	
}
