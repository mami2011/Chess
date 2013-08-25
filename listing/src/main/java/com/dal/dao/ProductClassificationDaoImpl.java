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

public class ProductClassificationDaoImpl extends BaseDAO implements ProductClassificationDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductClassification productClassification) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productClassification);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductClassification productClassification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productClassification);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductClassification productClassification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productClassification);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductClassification> findByClassificationId(long classificationId) {
		// TODO Auto-generated method stub
		String sql = "select * from product_classification where classification_id = :classification_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("classification_id", classificationId);
		query.addEntity(ProductClassification.class);
		List<ProductClassification> results = query.list();
		return  results;
	}
	

}
