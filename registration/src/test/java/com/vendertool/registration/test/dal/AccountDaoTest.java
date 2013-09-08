package com.vendertool.registration.test.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.Assert;

import com.mysema.query.types.Path;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.DeleteException;
import com.vendertool.common.dal.exception.FinderException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.dal.exception.UpdateException;
import com.vendertool.common.test.dal.BaseDaoTest;
import com.vendertool.registration.dal.dao.AccountDao;
import com.vendertool.registration.dal.dao.RegistrationDaoFactory;
import com.vendertool.registration.dal.dao.codegen.QAccount;
import com.vendertool.registration.dal.fieldset.FieldSets;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.core.AccountRoleEnum;
import com.vendertool.sharedtypes.core.ContactDetails;

public class AccountDaoTest extends BaseDaoTest{
	private static final int ACCOUNT_COUNT = 2;
	Account[] accounts;
	AccountDao dao;
	QAccount qa;
	
	protected AccountDaoTest() {
		super();
	}
	
	public static void main(String[] args) throws DBConnectionException,
			InsertException, DatabaseException, SQLException {
		AccountDaoTest test = new AccountDaoTest();
		test.testCRUD();
		test.cleanup();
	}
	
	@Override
	protected void setupTestData() {
		RegistrationDaoFactory factory = RegistrationDaoFactory.getInstance();
		dao = factory.getAccountDao();
		qa = QAccount.account;
		
		accounts = new Account[ACCOUNT_COUNT];
		for(int idx = 0; idx < ACCOUNT_COUNT; idx++) {
			accounts[idx] = createAccount(idx);
		}
	}

	private Account createAccount(int idx) {
		Account a = new Account();
		a.setEmailId("testemail"+idx+"@vendertooltest.com");
		a.setPassword("TestPassword"+idx);
		a.setPasswordSalt("passwordsalt"+idx);
		a.addRole(AccountRoleEnum.ROLE_USER);
		
		ContactDetails cd = new ContactDetails();
		cd.setFirstName("TestFirstName"+idx);
		cd.setMiddleName("M");
		cd.setLastName("TestLastName"+idx);
		a.setContactDetails(cd);
		
		Date now = new Date();
		a.setCreateDate(now);
		a.setLastModifiedDate(now);
		
		return a;
	}
	
	public void testCRUD() throws DBConnectionException, InsertException,
			DatabaseException, SQLException {
		
		initConnPool();
		
		//DAL insert
		log("======== INSERT TEST =======");
		insert();
		
		//DAL find & JUnit assert
		log("======== FIND AND ASSERT TEST =======");
		for(Account account : accounts) {
			Account dbaccount = findProfile(account.getEmailId());
			logAccount("findProfile ****\n", dbaccount);
			assertAccount(account, dbaccount);
		}
		
		//local update (non-dal)
		log("======== UPDATE ACCOUNT LOCALLY =======");
		updateLocalAccount(0);
		
		//DAL update
		log("======== UPDATE ACCOUNT TO THE DATABASE =======");
		update(accounts[0], FieldSets.UPDATESET.PROFILE);
		
		//DAL find
		log("======== FIND PROFILE TEST =======");
		Account dbaccount = findProfile(accounts[0].getEmailId());
		
		//JUnit assert
		logAccount("updateProfile ****\n", dbaccount);
		assertAccount(accounts[0], dbaccount);
		
		//DAL find PK
		log("======== FIND BY PK TEST =======");
		Long pk = findPK(accounts[0].getEmailId());
		
		//JUnit assert PK
		Assert.assertEquals(dbaccount.getId(), pk);
		
		//DAL find by readset
		log("======== FIND WITH READ SET TEST =======");
		dbaccount = findAccount(accounts[0].getEmailId(), FieldSets.READSET.SIGNIN);
		
		//JUnit assert read set
		Assert.assertNull(dbaccount.getContactDetails());
		Assert.assertNotNull(dbaccount.getEmailId());
		Assert.assertNotNull(dbaccount.getPassword());
		Assert.assertNotNull(dbaccount.getRoles());
		
		//DAL delete
		log("======== DELETE TEST =======");
		for(int idx = 0; idx < ACCOUNT_COUNT; idx++) {
			delete(accounts[idx].getEmailId());
		}
		
		//DAL find
		log("======== FIND AFTER DELETE TEST =======");
		for(int idx = 0; idx < ACCOUNT_COUNT; idx++) {
			pk = findPK(accounts[idx].getEmailId());
			Assert.assertNull(pk);
		}
		
		log("******   TEST DONE!!!   ******");
	}

	private void initConnPool() throws DBConnectionException, SQLException {
		//Connection pool set up
		Connection c = null;
		try {
			long start = System.currentTimeMillis();
			c = dao.getConnection();
			long end = System.currentTimeMillis();
			log("Connection pool set up time: " + (end - start));
		} finally {
			c.close();
		}
	}
	
	private void updateLocalAccount(int idx) {
		Account account = accounts[idx];
		ContactDetails cd = account.getContactDetails();
		cd.setFirstName("TestUpdatedFirstName"+idx);
		cd.setMiddleName("MU");
		cd.setLastName("TestUpdatedLastName"+idx);
	}

	private void assertAccount(Account expected, Account actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getEmailId(), actual.getEmailId());
		Assert.assertEquals(expected.getContactDetails().getFirstName(), actual.getContactDetails().getFirstName());
	}
	
	private void logAccount(String msg, Account account) {
		log(msg);
		log(account.toString());
	}
	
	private void insert() throws DBConnectionException, InsertException,
			DatabaseException {
		for(Account account : accounts) {
			dao.insertAccount(account);
		}
	}
	
	private Long findPK(String email) throws DBConnectionException,
			FinderException, DatabaseException {
		return dao.findAccountId(email);
	}
	
	private Account findAccount(String email, Path<?>[] readSet)
			throws DBConnectionException, FinderException, DatabaseException {
		return dao.findAccount(email, readSet);
	}
	
	private Account findProfile(String email) throws DBConnectionException,
			FinderException, DatabaseException {
		return dao.findAccountProfile(email);
	}
	
	private void update(Account account, Path<?>[] updateSet)
			throws DBConnectionException, UpdateException, DatabaseException {
		dao.updateAccount(account, updateSet);
	}
	
	private void delete(String email) throws DBConnectionException,
			DeleteException, DatabaseException {
		dao.deleteAccount(email);
	}
	
	private void log(String msg) {
		System.err.println(msg);
	}

	@Override
	protected void cleanup() {
		dao.cleanup();
	}
}
