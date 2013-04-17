/**
 * 
 */
package com.vendertool.registration.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.common.dal.BaseDaoImpl;
import com.vendertool.registration.dal.bof.AccountSubscription;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class AccountSubscriptionDaoImpl extends BaseDaoImpl implements AccountSubscriptionDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(accountSubscription);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(accountSubscription);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(accountSubscription);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public AccountSubscription findByStockCode(AccountSubscription accountSubscription) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product";
			
		SQLQuery query=getSession().createSQLQuery(sql);
		query.addEntity(AccountSubscription.class);
		List results = query.list();
		
		
	/*	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("employee_id", 10);
		List results = query.list();*/
		return null;
	}

}
