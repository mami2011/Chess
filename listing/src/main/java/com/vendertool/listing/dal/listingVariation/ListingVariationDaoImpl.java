/**
 * 
 */
package com.vendertool.listing.dal.listingVariation;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vendertool.common.dal.BaseDAO;
import com.vendertool.listing.dal.listing.Listing;

/**
 * @author murali HibernateDaoSupport
 */

public class ListingVariationDaoImpl extends BaseDAO implements ListingVariationDao {
	
	
	public void insert(ListingVariation listingVariation) {
		// TODO Auto-generated method stub
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.save(listingVariation);
		trans.commit();
	}


	public void update(ListingVariation listingVariation) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.update(listingVariation);
		trans.commit();

	}

	
	public void delete(ListingVariation listingVariation) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		session.delete(listingVariation);
		trans.commit();

	}

	public List<ListingVariation> findByAccountId(long accountId) {
		Session session = getDalSession();
		Transaction trans = session.beginTransaction();
		String sql = "select * from listing_variation where account_id = :account_id";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(Listing.class);
		List<ListingVariation> results = query.list();
		return  results;
	}

	
}