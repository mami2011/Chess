package com.vendertool.registration.bof;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseBOF;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.registration.dal.account.AccountDAOFactory;
import com.vendertool.registration.dal.account.AccountDao;
import com.vendertool.sharedtypes.core.Account;

public class AccountBOF extends BaseBOF {

	private static final Logger logger = Logger.getLogger(AccountBOF.class
			.getName());
	private AccountDao dao;

	// To make Singleton *** Start ***
	private static class AccountBOFSingletonHelper {
		private static final AccountBOF INSTANCE = new AccountBOF();
	}

	private AccountBOF() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.ACCOUNT_DAO);
		if (baseFactory != null) {
			AccountDAOFactory accountDAOFactory = (AccountDAOFactory) baseFactory;
			dao = accountDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static AccountBOF getInstance() {
		return AccountBOFSingletonHelper.INSTANCE;
	}

	public void insert(Account accountBO) {
		com.vendertool.registration.dal.account.Account accountDo = new com.vendertool.registration.dal.account.Account();
		accountDo.setEmailAddr(accountBO.getEmailId());
		accountDo.setFirstName(accountBO.getContactDetails().getFirstName());
		accountDo.setLastName(accountBO.getContactDetails().getLastName());
		accountDo.setPassword(accountBO.getPassword());
		accountDo.setSalt(accountBO.getPasswordSalt());
		accountDo.setRoles(accountBO.getRole().getValue());
		// Insert into DB
		logger.info(" Call AccountDaoImpl to insert : "
				+ accountBO.getEmailId());
		dao.insert(accountDo);
	}

}