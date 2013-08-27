package com.vendertool.registration.dal.address;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class AddressDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class AddressDAOFactorySingletonHelper {
		private static final AddressDAOFactory INSTANCE = new AddressDAOFactory();
	}

	private AddressDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.ADDRESS_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("addressDao");
			initialized = true;
		}
	}
	public static AddressDAOFactory getInstance() {
		return AddressDAOFactorySingletonHelper.INSTANCE;
	}

	public AddressDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (AddressDao) super.getBaseDAO();
		}
		return null;
	}
}