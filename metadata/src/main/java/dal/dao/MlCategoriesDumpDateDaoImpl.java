/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MlCategories;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MlCategoriesDumpDateDaoImpl extends HibernateDaoSupport implements MlCategoriesDumpDateDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MlCategoriesDumpDate mlCategoriesDumpDate) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mlCategoriesDumpDate);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MlCategoriesDumpDate mlCategoriesDumpDate) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mlCategoriesDumpDate);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MlCategoriesDumpDate mlCategoriesDumpDate) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mlCategoriesDumpDate);

	}


	public List<MlCategoriesDumpDate> findBySiteId(MlCategoriesDumpDate mlCategoriesDumpDate) {
		// TODO Auto-generated method stub
	
		String sql = "from MlCategoriesDumpDate WHERE siteId = ?";
		List <MlCategoriesDumpDate> results =getHibernateTemplate().find(sql,mlCategoriesDumpDate.getSiteId());
		return  results;
	}

}
