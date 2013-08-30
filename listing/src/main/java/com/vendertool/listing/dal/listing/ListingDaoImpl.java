/**
 * 
 */
package com.vendertool.listing.dal.listing;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;
import com.vendertool.listing.dal.listing.Listing;
import com.vendertool.listing.dal.listing.ListingDao;

/**
 * @author murali HibernateDaoSupport
 */

public class ListingDaoImpl extends BaseDAO implements ListingDao {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void insert(Listing listing) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(listing);
		trans.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void update(Listing listing) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(listing);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool
	 * .inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(Listing listing) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(listing);

	}

	
	public List<Listing> findByListingId(long listingId) {
		// TODO Auto-generated method stub
		String sql = "select * from listing where listing_id = :listing_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("listing_id", listingId);
		query.addEntity(Listing.class);
		List<Listing> results = query.list();
		return  results;
	}
	
	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<Listing> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from listing where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Listing.class);
		List<Listing> results = query.list();
		return  results;
	}

	
}