/**
 * 
 */
package com.vendertool.registration.dal.accountConfirmation;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali HibernateDaoSupport
 */

public class AccountConfirmationDaoImpl extends BaseDAO implements AccountConfirmationDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(AccountConfirmation accountConfirmation) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(accountConfirmation);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(AccountConfirmation accountConfirmation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(accountConfirmation);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(AccountConfirmation accountConfirmation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(accountConfirmation);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com
	 * .vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<AccountConfirmation> findByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from account_confirmation where account_id = :accountId";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("accountId", accountId);
		query.addEntity(AccountConfirmation.class);
		List<AccountConfirmation> results = query.list();
		return results;
	}

}
