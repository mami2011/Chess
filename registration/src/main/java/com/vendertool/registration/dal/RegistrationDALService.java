package com.vendertool.registration.dal;

import org.apache.log4j.Logger;

import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.registration.dal.dao.AccountConfirmationDao;
import com.vendertool.registration.dal.dao.AccountDao;
import com.vendertool.registration.dal.dao.PasswordHistoryDao;
import com.vendertool.registration.dal.dao.RegistrationDaoFactory;
import com.vendertool.registration.dal.fieldset.FieldSets;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountConfirmation;

public class RegistrationDALService {
	private static final Logger logger = Logger.getLogger(RegistrationDALService.class);
	ValidationUtil VUTIL = ValidationUtil.getInstance();
	AccountDao accountDao;
	AccountConfirmationDao accountConfDao;
	PasswordHistoryDao pwdHistoryDao;
	
	private RegistrationDALService() {
		accountDao = RegistrationDaoFactory.getInstance().getAccountDao();
		accountConfDao = RegistrationDaoFactory.getInstance().getAccountConfirmationDao();
		pwdHistoryDao = RegistrationDaoFactory.getInstance().getPasswordHistoryDao();
	}
	
	private static class RegistrationDALServiceHolder {
		private static final RegistrationDALService INSTANCE = new RegistrationDALService();
	}
	
	public static RegistrationDALService getInstance() {
		return RegistrationDALServiceHolder.INSTANCE;
	}
	
	
	public Long registerAccount(Account account) throws DBConnectionException,
			FinderException, InsertException, DatabaseException {
		
		if(VUTIL.isNull(account)) {
			return null;
		}
		
		Long accountId = accountDao.generateNextSequence();
		AccountConfirmation accConf = account.getAccountConf();
		if(accConf == null) {
			throw new InsertException(
					"Session tokens are not generated for account confirmation");
		}
		
		account.setId(accountId);
		accountConfDao.insertAccountConfirmation(accountId, accConf);
		
		try {
			accountDao.insertAccount(account);
		} catch (Exception e) {
			//manually rollback
			Long aid = accountDao.findAccountId(account.getEmailId());
			if(aid == null) { //if not null just return the response, because the account is already created
				try {
					accountConfDao.deleteAccountConfirmation(accountId);
					return null;
				} catch (DeleteException de) {
					//don't throw rollback exceptions, just log it
					logger.debug(de.getMessage(), de);
				}
			}
		}
		
		return accountId;
	}
	
	
	public void changeAccountProfile(Account account)
			throws DBConnectionException, UpdateException, DatabaseException {
		
		if(VUTIL.isNull(account)) {
			return;
		}
		
		accountDao.updateAccount(account, FieldSets.ACCOUNT_UPDATESET.PROFILE);
	}
	
	
	public boolean changePassword(String email, String oldPassword,
			String newPassword) throws FinderException, DBConnectionException,
			DatabaseException, InsertException {
		
		if (VUTIL.isNull(email) || VUTIL.isNull(oldPassword)
				|| VUTIL.isNull(newPassword)) {
			return false;
		}
		
		Account account = accountDao.findAccount(email, FieldSets.ACCOUNT_READSET.PASSWORD);
		
		if(VUTIL.isNull(account)) {
			throw new FinderException("Unable to find the account");
		}
		
		Long id = pwdHistoryDao.insertPreviousPassword(account.getId(),
				account.getPassword(), account.getPasswordSalt());
		
		try {
			accountDao.updatePassword(email, newPassword);
		} catch (Exception e) {
			//Check if the update was good, but the exception was somewhere upstream
			Account changedAcc = accountDao.findAccount(email,
					FieldSets.ACCOUNT_READSET.PASSWORD);
			
			if(VUTIL.isNull(changedAcc) || (!changedAcc.getPassword().equals(newPassword))) {
				try {
					pwdHistoryDao.deletePasswordHistory(id);
				} catch (Exception ex) {
					//Don't throw exception during rollback, just log it
					logger.debug(ex.getMessage(), ex);
				}
			}
			
			return false;
		}
		
		return true;
	}
	
	
	public boolean changeEmail(String oldEmail, String newEmail)
			throws DBConnectionException, UpdateException, DatabaseException {
		
		if(VUTIL.isNull(oldEmail) || VUTIL.isNull(newEmail)) {
			return false;
		}
		
		accountDao.updateEmail(oldEmail, newEmail);
		return true;
	}
	
	
	public Long getAccountId(String email) throws DBConnectionException,
			FinderException, DatabaseException {
		
		if(VUTIL.isNull(email)) {
			return null;
		}
		
		return accountDao.findAccountId(email);
	}
	
	
	public Account getAccountDetails(String email)
			throws DBConnectionException, FinderException, DatabaseException {
		
		if(VUTIL.isNull(email)) {
			return null;
		}
		
		return accountDao.findAccount(email, FieldSets.ACCOUNT_READSET.PROFILE);
	}
	
	
	public boolean isPreviouslyUsedPassword(String email, String newPassword)
			throws DBConnectionException, FinderException, DatabaseException {
		
		if(VUTIL.isNull(newPassword) || VUTIL.isNull(email)) {
			return false;
		}
		
		Long accountId = accountDao.findAccountId(email);
		
		if(VUTIL.isNull(accountId)) {
			throw new FinderException("Unable to find the account");
			
		}
		
		String pwd = pwdHistoryDao.findMatchingPassword(accountId, newPassword);
		return (!VUTIL.isEmpty(pwd));
		
	}
	
	
//	public List<AccountSecurityQuestion> getAccountSecurityQuestions(String email) {
//		
//	}
//	
//	public void updateAccountSecurityQuestions(String email, List<AccountSecurityQuestion>) {
//		
//	}
}
