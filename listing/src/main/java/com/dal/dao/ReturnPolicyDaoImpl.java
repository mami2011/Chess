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

public class ReturnPolicyDaoImpl extends BaseDAO implements ReturnPolicyDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ReturnPolicy returnPolicy) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(returnPolicy);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ReturnPolicy returnPolicy) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(returnPolicy);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ReturnPolicy returnPolicy) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(returnPolicy);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ReturnPolicy> findByReturnPolicyId(long policyId) {
		// TODO Auto-generated method stub
		String sql = "select * from return_policy where policy_id = :policy_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("policy_id", policyId);
		query.addEntity(ReturnPolicy.class);
		List<ReturnPolicy> results = query.list();
		return  results;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ReturnPolicy> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from return_policy where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(ReturnPolicy.class);
		List<ReturnPolicy> results = query.list();
		return  results;
	}

}
