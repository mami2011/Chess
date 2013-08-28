package com.vendertool.registration.bof;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseBOF;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.registration.dal.passwordHistory.PasswordHistoryDAOFactory;
import com.vendertool.registration.dal.passwordHistory.PasswordHistoryDao;


public class PasswordHistoryBOF extends BaseBOF {

	private static final Logger logger = Logger.getLogger(PasswordHistoryBOF.class
			.getName());
	private PasswordHistoryDao dao;

	// To make Singleton *** Start ***
	private static class PasswordHistoryBOFSingletonHelper {
		private static final PasswordHistoryBOF INSTANCE = new PasswordHistoryBOF();
	}

	private PasswordHistoryBOF() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.PASSWORD_HISTORY_DAO);
		if (baseFactory != null) {
			PasswordHistoryDAOFactory passwordHistoryDAOFactory = (PasswordHistoryDAOFactory) baseFactory;
			dao = passwordHistoryDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static PasswordHistoryBOF getInstance() {
		return PasswordHistoryBOFSingletonHelper.INSTANCE;
	}

	/*public void insert(PasswordHistory passwordHistoryBO) {
		com.vendertool.registration.dal.passwordHistory.PasswordHistory passwordHistoryDo = new com.vendertool.registration.dal.passwordHistory.PasswordHistory();
		passwordHistoryDo.setEmailAddr(passwordHistoryBO.getEmailId());
		passwordHistoryDo.setFirstName(passwordHistoryBO.getContactDetails().getFirstName());
		passwordHistoryDo.setLastName(passwordHistoryBO.getContactDetails().getLastName());
		passwordHistoryDo.setPassword(passwordHistoryBO.getPassword());
		passwordHistoryDo.setSalt(passwordHistoryBO.getPasswordSalt());
		passwordHistoryDo.setRoles(passwordHistoryBO.getRole().getValue());
		// Insert into DB
		logger.info(" Call PasswordHistoryDaoImpl to insert : "
				+ passwordHistoryBO.getEmailId());
		dao.insert(passwordHistoryDo);
	}*/

}