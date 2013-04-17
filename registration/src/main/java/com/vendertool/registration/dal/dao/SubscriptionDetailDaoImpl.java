/**
 * 
 */
package com.vendertool.registration.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.common.dal.BaseDaoImpl;
import com.vendertool.registration.dal.bof.SubscriptionDetail;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class SubscriptionDetailDaoImpl extends BaseDaoImpl implements SubscriptionDetailDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(subscriptionDetail);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(subscriptionDetail);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(subscriptionDetail);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public SubscriptionDetail findByStockCode(SubscriptionDetail subscriptionDetail) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product";
			
		SQLQuery query=getSession().createSQLQuery(sql);
		query.addEntity(SubscriptionDetail.class);
		List results = query.list();
		
		
	/*	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("employee_id", 10);
		List results = query.list();*/
		return null;
	}

}
