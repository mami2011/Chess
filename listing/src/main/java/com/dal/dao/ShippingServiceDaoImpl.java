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

public class ShippingServiceDaoImpl extends BaseDAO implements ShippingServiceDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ShippingService shippingService) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(shippingService);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ShippingService shippingService) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(shippingService);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ShippingService shippingService) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(shippingService);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ShippingService> findByShippingServiceId(long shippingServiceId) {
		// TODO Auto-generated method stub
		String sql = "select * from shipping_service where shipping_service_id = :shipping_service_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("shipping_service_id", shippingServiceId);
		query.addEntity(ShippingPolicy.class);
		List<ShippingService> results = query.list();
		return  results;
	}
	

}
