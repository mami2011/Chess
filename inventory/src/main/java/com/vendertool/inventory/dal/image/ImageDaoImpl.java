/**
 * 
 */
package com.vendertool.inventory.dal.image;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;

/**
 * @author murali HibernateDaoSupport
 */

public class ImageDaoImpl extends BaseDAO implements ImageDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(Image image) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(image);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Image image) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.update(image);
		trans.commit();


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Image image) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.delete(image);
		trans.commit();
	}

	/*public List<Image> findByAccountId(long accountId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
	}*/

	
}