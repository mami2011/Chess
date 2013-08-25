/**
 * 
 */
package com.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;


import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ShippingPolicyDaoImpl extends BaseDAO implements ShippingPolicyDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ShippingPolicy shippingPolicy) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(shippingPolicy);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ShippingPolicy shippingPolicy) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(shippingPolicy);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ShippingPolicy shippingPolicy) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(shippingPolicy);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ShippingPolicy> findByShippingPolicyId(long policyId) {
		// TODO Auto-generated method stub
		String sql = "select * from shipping_policy where policy_id = :policy_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("policy_id", policyId);
		query.addEntity(ShippingPolicy.class);
		List<ShippingPolicy> results = query.list();
		return  results;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ShippingPolicy> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from shipping_policy where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(ShippingPolicy.class);
		List<ShippingPolicy> results = query.list();
		return  results;
	}

}
