/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MlCategories;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MlCategoriesDaoImpl extends HibernateDaoSupport implements MlCategoriesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MlCategories mlCategories) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mlCategories);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MlCategories mlCategories) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mlCategories);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MlCategories mlCategories) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mlCategories);

	}


	public List<MlCategories> findByCategoryId(MlCategories mlCategories) {
		// TODO Auto-generated method stub
	
		String sql = "from MlCategories WHERE categoryId = ?";
		List <MlCategories> results =getHibernateTemplate().find(sql,mlCategories.getCategoryId());
		return  results;
	}
	
/*	public List<MlCategories> findByCategoryId(MlCategories mlCategories) {
		// TODO Auto-generated method stub
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(
				"select * from ML_CATEGORIES m where m.category_id = :categoryId")
				.addEntity(MlCategories.class)
				.setParameter("categoryId",mlCategories.getCategoryId() );
				List results = query.list();
				
		return  results;
	}
	
*/
	
	

}
