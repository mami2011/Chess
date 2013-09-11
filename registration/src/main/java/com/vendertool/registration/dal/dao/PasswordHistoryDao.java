package com.vendertool.registration.dal.dao;

import java.util.Date;
import java.util.List;

import com.vendertool.common.dal.dao.BaseDao;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;

public interface PasswordHistoryDao extends BaseDao {
	
	public void insertPreviousPassword(Long accountId, String password, String salt)
			throws DBConnectionException, InsertException, DatabaseException;
	
	public String findMatchingPassword(Long accountId, String newpassword)
			throws DBConnectionException, FinderException, DatabaseException;
	
	public List<String> findAllPreviousPasswords(Long accountId)
			throws DBConnectionException, FinderException, DatabaseException;
	
	public void deletePreviousPasswords(Long accountId, Date olderthan)
			throws DBConnectionException, DeleteException, DatabaseException;
}
