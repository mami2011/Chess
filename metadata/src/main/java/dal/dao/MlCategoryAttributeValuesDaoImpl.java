/**
 * 
 */
package dal.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dal.dao.MlCategoryAttributeValues;


/**
 * @author murali
 *HibernateDaoSupport
 */
public class MlCategoryAttributeValuesDaoImpl extends HibernateDaoSupport implements MlCategoryAttributeValuesDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MlCategoryAttributeValues mlCategoryAttributeValues) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(mlCategoryAttributeValues);
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MlCategoryAttributeValues mlCategoryAttributeValues) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(mlCategoryAttributeValues);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MlCategoryAttributeValues mlCategoryAttributeValues) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(mlCategoryAttributeValues);

	}


	public List<MlCategoryAttributeValues> findByAttributeValueId(MlCategoryAttributeValues mlCategoryAttributeValues) {
		// TODO Auto-generated method stub
	
		String sql = "from MlCategoryAttributeValues WHERE attributeId = ?";
		List <MlCategoryAttributeValues> results =getHibernateTemplate().find(sql,mlCategoryAttributeValues.getAttributeId());
		return  results;
	}

}
