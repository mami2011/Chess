/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MlCategoryAttributes;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MlCategoryAttributesDaoImpl extends HibernateDaoSupport implements MlCategoryAttributesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MlCategoryAttributes MlCategoryAttributes) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(MlCategoryAttributes);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MlCategoryAttributes MlCategoryAttributes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(MlCategoryAttributes);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MlCategoryAttributes mlCategoryAttributes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mlCategoryAttributes);

	}


	public List<MlCategoryAttributes> findByCategoryId(MlCategoryAttributes mlCategoryAttributes) {
		// TODO Auto-generated method stub
	
		String sql = "from MlCategoryAttributes WHERE categoryId = ?";
		List <MlCategoryAttributes> results =getHibernateTemplate().find(sql,mlCategoryAttributes.getCategoryId());
		return  results;
	}
	public List<MlCategoryAttributes> findByAttributeId(MlCategoryAttributes mlCategoryAttributes) {
		// TODO Auto-generated method stub
	
		String sql = "from MlCategoryAttributes WHERE categoryId = ?";
		List <MlCategoryAttributes> results =getHibernateTemplate().find(sql,mlCategoryAttributes.getCategoryId());
		return  results;
	}

}
