package com.vendertool.registration.dal.passwordHistory;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.common.dal.deprecate.BaseDAO;


public class PasswordHistoryDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class PasswordHistoryDAOFactorySingletonHelper {
		private static final PasswordHistoryDAOFactory INSTANCE = new PasswordHistoryDAOFactory();
	}

	private PasswordHistoryDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.PASSWORD_HISTORY_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("passwordHistoryDao");
			initialized = true;
		}
	}
	public static PasswordHistoryDAOFactory getInstance() {
		return PasswordHistoryDAOFactorySingletonHelper.INSTANCE;
	}

	public PasswordHistoryDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (PasswordHistoryDao) super.getBaseDAO();
		}
		return null;
	}
}