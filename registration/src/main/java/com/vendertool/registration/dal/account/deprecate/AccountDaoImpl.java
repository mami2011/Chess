package com.vendertool.registration.dal.account.deprecate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import com.vendertool.common.dal.deprecate.BaseDAO;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;

public class AccountDaoImpl extends BaseDAO implements AccountDao {
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	public void insert(Account account) throws DBConnectionException, InsertException {
		Session session = null;
		try {
			session = getDalSession();
		} catch(HibernateException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DBConnectionException(ex);
		}
		
		if(session == null) {
			DBConnectionException dbconex = new DBConnectionException("Unable to establish connection");
			logger.debug(dbconex.getMessage(), dbconex);
			throw dbconex;
		}
		
		Transaction trans = session.beginTransaction();
		
		try { 
			session.save(account);
			trans.commit();
		} catch (HibernateException hex) {
			logger.debug(hex.getMessage(), hex);
			throw new InsertException(hex);
		} catch (Exception ex) {
			logger.debug(ex.getMessage(), ex);
			throw new InsertException(ex);
		}
	}

	public void update(Account account) throws DBConnectionException, UpdateException {
		try {
			getHibernateTemplate().update(account);
		} catch (DataAccessResourceFailureException darfex) {
			DBConnectionException dbconex = new DBConnectionException(darfex.getMessage());
			logger.debug(dbconex.getMessage(), dbconex);
			throw dbconex;
		} catch (HibernateException hex) {
			logger.debug(hex.getMessage(), hex);
			throw new UpdateException(hex);
		} catch (DataAccessException daex) {
			logger.debug(daex.getMessage(), daex);
			throw new UpdateException(daex);
		}
	}

	public void delete(Account account) throws DBConnectionException, DeleteException {
		try {
			getHibernateTemplate().delete(account);
		} catch (DataAccessResourceFailureException darfex) {
			DBConnectionException dbconex = new DBConnectionException(darfex.getMessage());
			logger.debug(dbconex.getMessage(), dbconex);
			throw dbconex;
		} catch (HibernateException hex) {
			logger.debug(hex.getMessage(), hex);
			throw new DeleteException(hex);
		} catch (DataAccessException daex) {
			logger.debug(daex.getMessage(), daex);
			throw new DeleteException(daex);
		}
	}


	public List<Account> findByAccountId(Long accountId) {
		String sql = "select * from account where account_id = :accountId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("accountId", accountId);
		query.addEntity(Account.class);
		@SuppressWarnings("unchecked")
		List<Account> results = query.list();
		return results;
	}
	
	public long getNextValue(){
		 SQLQuery query = getSession().createSQLQuery("select nextval('accountId');");
		 @SuppressWarnings("unchecked")
		List<Long> nextValue = query.list();
		 return nextValue.get(0);
	}

	public List<Account> findByEmailId(String emailId) {
		String sql = "select * from account where email_addr = :emailId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("emailId", emailId);
		query.addEntity(Account.class);
		@SuppressWarnings("unchecked")
		List<Account> results = query.list();
		return results;
	}
}