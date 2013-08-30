/**
 * 
 */
package com.vendertool.listing.dal.listingVariation;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;
import com.vendertool.inventory.dal.listingVariation.ListingVariation;
import com.vendertool.inventory.dal.listingVariation.ListingVariationDao;

/**
 * @author murali HibernateDaoSupport
 */

public class ListingVariationDaoImpl extends BaseDAO implements ListingVariationDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(ListingVariation listingVariation) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(listingVariation);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ListingVariation listingVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(listingVariation);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ListingVariation listingVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(listingVariation);

	}

	public List<ListingVariation> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}