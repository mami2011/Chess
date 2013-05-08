/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MercadolibreCategories;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MercadolibreCategoriesDaoImpl extends HibernateDaoSupport implements MercadolibreCategoriesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MercadolibreCategories mercadolibreCategories) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mercadolibreCategories);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MercadolibreCategories mercadolibreCategories) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mercadolibreCategories);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MercadolibreCategories mercadolibreCategories) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mercadolibreCategories);

	}


	public List<MercadolibreCategories> findByCategoryId(MercadolibreCategories mercadolibreCategories) {
		// TODO Auto-generated method stub
	
		String sql = "from MercadolibreCategories WHERE categoryId = ?";
		List <MercadolibreCategories> results =getHibernateTemplate().find(sql,mercadolibreCategories.getCategoryId());
		return  results;
	}

}
