/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MercadolibreCategoryAttributeValues;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MercadolibreCategoryAttributeValuesDaoImpl extends HibernateDaoSupport implements MercadolibreCategoryAttributeValuesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mercadolibreCategoryAttributeValues);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mercadolibreCategoryAttributeValues);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mercadolibreCategoryAttributeValues);

	}


	public List<MercadolibreCategoryAttributeValues> findByAttributeValueId(MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues) {
		// TODO Auto-generated method stub
	
		String sql = "from MercadolibreCategoryAttributeValues WHERE attributeId = ?";
		List <MercadolibreCategoryAttributeValues> results =getHibernateTemplate().find(sql,mercadolibreCategoryAttributeValues.getAttributeId());
		return  results;
	}

}
