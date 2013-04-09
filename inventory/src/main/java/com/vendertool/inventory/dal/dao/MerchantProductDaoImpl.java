/**
 * 
 */
package com.vendertool.inventory.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vendertool.inventory.dal.bof.MerchantProduct;

/**
 * @author murali
 *
 */
public class MerchantProductDaoImpl extends HibernateDaoSupport implements MerchantProductDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void save(MerchantProduct product) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(product);
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MerchantProduct product) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(product);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MerchantProduct product) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(product);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public MerchantProduct findByStockCode(MerchantProduct product) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product";
			
		SQLQuery query=getSession().createSQLQuery(sql);
		query.addEntity(MerchantProduct.class);
		List results = query.list();
		
		
	/*	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("employee_id", 10);
		List results = query.list();*/
		return null;
	}

}
