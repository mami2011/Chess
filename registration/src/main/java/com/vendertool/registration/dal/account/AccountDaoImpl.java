/**
 * 
 */
package com.vendertool.registration.dal.account;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali HibernateDaoSupport
 */

public class AccountDaoImpl extends BaseDAO implements AccountDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(Account account) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(account);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Account account) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(account);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Account account) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(account);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com
	 * .vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Account> findByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from account where account_id = :accountId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("accountId", accountId);
		query.addEntity(Account.class);
		List<Account> results = query.list();
		return results;
	}
	
	public long getNextValue(){
		//Session session = getDalSession();
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		 SQLQuery query = session.createSQLQuery("select nextval('accountId');");
		// query.setParameter("BatchJobId1", "BatchJobId");
		// query.addEntity(Long.class);
		 List<Long> nextValue = query.list();
		 trans.commit();
		 return nextValue.get(0);
	}

	public List<Account> findByEmailId(String emailId) {
		String sql = "select * from account where email_addr = :emailId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("emailId", emailId);
		query.addEntity(Account.class);
		List<Account> results = query.list();
		return results;
	}
}