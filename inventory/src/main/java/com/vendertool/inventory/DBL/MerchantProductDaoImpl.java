/**
 * 
 */
package com.vendertool.inventory.DBL;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
		return null;
	}

}
