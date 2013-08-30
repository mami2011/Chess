package com.vendertool.listing.dal.listingVariation;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.inventory.dal.listingVariation.ListingVariationDao;


public class ListingVariationDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class ListingVariationDAOFactorySingletonHelper {
		private static final ListingVariationDAOFactory INSTANCE = new ListingVariationDAOFactory();
	}

	private ListingVariationDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.LISTING_VARIATION_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("listingVariationDao");
			initialized = true;
		}
	}
	public static ListingVariationDAOFactory getInstance() {
		return ListingVariationDAOFactorySingletonHelper.INSTANCE;
	}

	public ListingVariationDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (ListingVariationDao) super.getBaseDAO();
		}
		return null;
	}
}