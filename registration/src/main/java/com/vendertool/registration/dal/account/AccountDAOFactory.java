package com.vendertool.registration.dal.account;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseDAO;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;


public class AccountDAOFactory extends BaseDAOFactory{

	private boolean initialized;
	// To make Singleton *** Start ***
	private static class AccountDAOFactorySingletonHelper {
		private static final AccountDAOFactory INSTANCE = new AccountDAOFactory();
	}

	private AccountDAOFactory() {
		DAOFactoryRegistry.getInstance().register(DAOFactoryKey.ACCOUNT_DAO, this);
		
	}
	// To make Singleton *** End ***

	public void init(){
		if(!initialized){
			initDAOBean("accountDao");
			initialized = true;
		}
	}
	public static AccountDAOFactory getInstance() {
		return AccountDAOFactorySingletonHelper.INSTANCE;
	}

	public AccountDao getDAO() {
		BaseDAO baseDao = super.getBaseDAO();
		if(baseDao != null){
			return (AccountDao) super.getBaseDAO();
		}
		return null;
	}
}