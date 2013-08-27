package com.vendertool.registration.bof;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseBOF;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmationDAOFactory;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmationDao;
import com.vendertool.sharedtypes.core.AccountConfirmation;

public class AccountConfirmationBOF extends BaseBOF {

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
		
	private static final Logger logger = Logger.getLogger(AccountConfirmationBOF.class
			.getName());
	private AccountConfirmationDao dao;

	// To make Singleton *** Start ***
	private static class AccountConfirmationBOFSingletonHelper {
		private static final AccountConfirmationBOF INSTANCE = new AccountConfirmationBOF();
	}

	private AccountConfirmationBOF() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.ACCOUNT_CONFIRMATION_DAO);
		if (baseFactory != null) {
			AccountConfirmationDAOFactory accountConfirmationDAOFactory = (AccountConfirmationDAOFactory) baseFactory;
			dao = accountConfirmationDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static AccountConfirmationBOF getInstance() {
		return AccountConfirmationBOFSingletonHelper.INSTANCE;
	}

	public void insert(AccountConfirmation accountConfirmationBO) {
		com.vendertool.registration.dal.accountConfirmation.AccountConfirmation accountConfirmationDo = new com.vendertool.registration.dal.accountConfirmation.AccountConfirmation();
		accountConfirmationDo.setConfirmationDate(date);
		accountConfirmationDo.setNumberOfAttempts((byte) accountConfirmationBO.getConfirmationAttempts());
		
		dao.insert(accountConfirmationDo);
	}

}