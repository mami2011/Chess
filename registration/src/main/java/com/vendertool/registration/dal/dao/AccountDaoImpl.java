package com.vendertool.registration.dal.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysema.query.Tuple;
import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;
import com.mysema.query.types.Path;
import com.vendertool.common.dal.dao.BaseDaoImpl;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.registration.dal.dao.codegen.QAccount;
import com.vendertool.registration.dal.fieldset.FieldSets;
import com.vendertool.sharedtypes.core.Account;

public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	ValidationUtil VUTIL = ValidationUtil.getInstance();
			
	@Override
	public void insertAccount(Account account) throws DBConnectionException,
			InsertException, DatabaseException {
		
		Connection connection = getConnection();
		
		if(account == null) {
			InsertException ie = new InsertException("Cannot insert null account");
			logger.debug(ie.getMessage(), ie);
			throw ie;
		}
		
		QAccount a = QAccount.account;
    	SQLTemplates template = new MySQLTemplates();  	

		SQLInsertClause s = new SQLInsertClause(connection, template, a)
				.populate(account, new AccountMapper(account, a.all()));
    	
    	//Always log the query before executing it
    	logger.info("DAL QUERY: " + s.toString());
    	
    	try {
    		s.execute();
    	} catch (Exception e) {
    		InsertException ie = new InsertException(e);
			logger.debug(ie.getMessage(), ie);
			throw ie;
    	}
	}

	@Override
	public Account findAccountProfile(String email) throws DBConnectionException,
			FinderException, DatabaseException {
		
		return findAccountByReadSet(email, FieldSets.READSET.PROFILE);
	}
	
	@Override
	public Account findAccount(String email, Path<?>[] readSet)
			throws DBConnectionException, FinderException, DatabaseException {
		
		return findAccountByReadSet(email, readSet);
	}

	private Account findAccountByReadSet(String email, Path<?>[] readSet)
			throws DBConnectionException, FinderException, DatabaseException {
		
		if(VUTIL.isEmpty(email)) {
			FinderException fe = new FinderException("Cannot find account with null email");
			logger.debug(fe.getMessage(), fe);
			throw fe;
		}
		
		QAccount a = QAccount.account;
		
		Connection connection = getConnection();
		
		SQLTemplates template = new MySQLTemplates(); // SQL-dialect
		SQLQuery query = new SQLQuery(connection, template)
							.from(a)
							.where(a.emailAddr.eq(email));
		
    	//Always log the query before executing it
    	logger.info("DAL QUERY: " + query.toString());
    	
    	List<Tuple> rows = query.list(readSet);
    	
    	if((rows == null) || (rows.isEmpty())) {
    		return null;
    	}
    	
		return AccountMapper.convert(rows.get(0), readSet);
	}
	

	@Override
	public void updateAccount(Account account, Path<?>[] updateSet)
			throws DBConnectionException, UpdateException, DatabaseException {
		
		if((account == null) || (updateSet == null)){
			UpdateException ue = new UpdateException("Cannot update null account");
			logger.debug(ue.getMessage(), ue);
			throw ue;
		}
		
		Connection connection = getConnection();
		
		QAccount a = QAccount.account;
		
    	SQLTemplates template = new MySQLTemplates();  	

    	SQLUpdateClause s = new SQLUpdateClause(connection, template, a)
				.populate(account, new AccountMapper(account, updateSet));
    	
    	//Always log the query before executing it
    	logger.info("DAL QUERY: " + s.toString());
    	
    	try {
    		s.execute();
    	} catch (Exception e) {
    		UpdateException ue = new UpdateException(e);
			logger.debug(ue.getMessage(), ue);
			throw ue;
    	}
		
	}

	@Override
	public void updateEmail(String oldEmail, String newEmail)
			throws DBConnectionException, UpdateException {
		// XXX Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String email, String password)
			throws DBConnectionException, UpdateException {
		// XXX Auto-generated method stub
		
	}


	@Override
	public void deleteAccount(String email) throws DBConnectionException,
			DeleteException {
		// XXX Auto-generated method stub
		
	}

	@Override
	public String findAccountEmail(String email) throws DBConnectionException,
			FinderException {
		// XXX Auto-generated method stub
		return null;
	}
}
