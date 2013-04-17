/**
 * 
 */
package com.vendertool.registration.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.common.dal.BaseDaoImpl;
import com.vendertool.registration.dal.bof.Description;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class DescriptionDaoImpl extends BaseDaoImpl implements DescriptionDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (Description description) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(description);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Description description) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(description);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Description description) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(description);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public Description findByStockCode(Description description) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product";
			
		SQLQuery query=getSession().createSQLQuery(sql);
		query.addEntity(Description.class);
		List results = query.list();
		
		
	/*	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("employee_id", 10);
		List results = query.list();*/
		return null;
	}

}
