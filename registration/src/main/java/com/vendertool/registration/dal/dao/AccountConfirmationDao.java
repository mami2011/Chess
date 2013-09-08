package com.vendertool.registration.dal.dao;

import com.vendertool.common.dal.dao.BaseDao;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;
import com.vendertool.sharedtypes.core.AccountConfirmation;

public interface AccountConfirmationDao extends BaseDao {
	public void insertAccountConfirmation(Long accountId, AccountConfirmation accountConf)
			throws DBConnectionException, InsertException, DatabaseException;
	
	public void updateConfirmationAttempts(Long accountId, Long pkId, int attempts)
			throws DBConnectionException, UpdateException, DatabaseException;
	
	public void deleteAccountConfirmation(Long accountId)
			throws DBConnectionException, DeleteException, DatabaseException;
	
	public AccountConfirmation findLatestAccountConfirmation(Long accountId)
			throws DBConnectionException, FinderException, DatabaseException;
}
