/**
 * 
 */
package com.vendertool.registration.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;

import com.vendertool.common.dal.BaseDaoImpl;
import com.vendertool.registration.dal.bof.Address;

/**
 * @author murali
 *HibernateDaoSupport
 */
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (Address address) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(address);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Address address) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(address);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public Address findByStockCode(Address address) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product";
			
		SQLQuery query=getSession().createSQLQuery(sql);
		query.addEntity(Address.class);
		List results = query.list();
		
		
	/*	String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("employee_id", 10);
		List results = query.list();*/
		return null;
	}

}
