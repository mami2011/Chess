/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MercadolibreCategoryAttributes;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MercadolibreCategoryAttributesDaoImpl extends HibernateDaoSupport implements MercadolibreCategoryAttributesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MercadolibreCategoryAttributes mercadolibreCategoryAttributes) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mercadolibreCategoryAttributes);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MercadolibreCategoryAttributes mercadolibreCategoryAttributes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mercadolibreCategoryAttributes);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MercadolibreCategoryAttributes mercadolibreCategoryAttributes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mercadolibreCategoryAttributes);

	}


	public List<MercadolibreCategoryAttributes> findByCategoryId(MercadolibreCategoryAttributes mercadolibreCategoryAttributes) {
		// TODO Auto-generated method stub
	
		String sql = "from MercadolibreCategoryAttributes WHERE categoryId = ?";
		List <MercadolibreCategoryAttributes> results =getHibernateTemplate().find(sql,mercadolibreCategoryAttributes.getCategoryId());
		return  results;
	}
	public List<MercadolibreCategoryAttributes> findByAttributeId(MercadolibreCategoryAttributes mercadolibreCategoryAttributes) {
		// TODO Auto-generated method stub
	
		String sql = "from MercadolibreCategoryAttributes WHERE categoryId = ?";
		List <MercadolibreCategoryAttributes> results =getHibernateTemplate().find(sql,mercadolibreCategoryAttributes.getCategoryId());
		return  results;
	}

}
