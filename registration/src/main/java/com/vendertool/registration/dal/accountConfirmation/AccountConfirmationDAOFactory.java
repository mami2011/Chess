package com.vendertool.registration.dal.accountConfirmation;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.common.dal.deprecate.BaseDAO;


public class AccountConfirmationDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class AccountConfirmationDAOFactorySingletonHelper {
		private static final AccountConfirmationDAOFactory INSTANCE = new AccountConfirmationDAOFactory();
	}

	private AccountConfirmationDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.ACCOUNT_CONFIRMATION_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("accountConfirmationDao");
			initialized = true;
		}
	}
	public static AccountConfirmationDAOFactory getInstance() {
		return AccountConfirmationDAOFactorySingletonHelper.INSTANCE;
	}

	public AccountConfirmationDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (AccountConfirmationDao) super.getBaseDAO();
		}
		return null;
	}
}