/**
 * 
 */
package com.vendertool.registration.dal.passwordHistory;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.deprecate.BaseDAO;

/**
 * @author murali
 *HibernateDaoSupport
 */


public class PasswordHistoryDaoImpl extends BaseDAO implements PasswordHistoryDao {


	public void insert(PasswordHistory passwordHistory) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(passwordHistory);
		trans.commit();
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(PasswordHistory passwordHistory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(passwordHistory);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(PasswordHistory passwordHistory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(passwordHistory);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<PasswordHistory> findByAccountId(Long account_id) {
		// TODO Auto-generated method stub
		String sql = "select * from password_history where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("aaccount_id", account_id);
		query.addEntity(PasswordHistory.class);
		List<PasswordHistory> results = query.list();
		return results;
	}
}