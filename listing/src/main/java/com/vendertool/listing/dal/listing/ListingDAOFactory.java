package com.vendertool.listing.dal.listing;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.listing.dal.listing.ListingDAOFactory;
import com.vendertool.listing.dal.listing.ListingDao;


public class ListingDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ListingDAOFactorySingletonHelper {
		private static final ListingDAOFactory INSTANCE = new ListingDAOFactory();
	}

	private ListingDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.LISTING_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("listingDao");
			initialized = true;
		}
	}
	public static ListingDAOFactory getInstance() {
		return ListingDAOFactorySingletonHelper.INSTANCE;
	}

	public ListingDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ListingDao) super.getBaseDAO();
		}
		return null;
	}
}