package com.vendertool.registration.test.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.vendertool.common.SessionIdGenerator;
import com.vendertool.common.dal.exception.DBConnectionException;
import com.vendertool.common.dal.exception.DatabaseException;
import com.vendertool.common.dal.exception.InsertException;
import com.vendertool.common.test.dal.BaseDaoTest;
import com.vendertool.registration.dal.dao.AccountConfirmationDao;
import com.vendertool.registration.dal.dao.RegistrationDaoFactory;
import com.vendertool.registration.dal.dao.codegen.QAccountConfirmation;
import com.vendertool.sharedtypes.core.AccountConfirmation;

public class AccountConfirmationDaoTest extends BaseDaoTest{

	private static final int ACCOUNT_COUNT = 2;
	private static final long START_ACCOUNT_ID = 600;
	
	AccountConfirmation[] accConfs;
	AccountConfirmationDao dao;
	QAccountConfirmation ac;
	
	protected AccountConfirmationDaoTest() {
		super();
	}
	
	public static void main(String[] args) throws DBConnectionException,
			InsertException, DatabaseException, SQLException {
		new AccountConfirmationDaoTest().testCRUD();
	}
	
	@Override
	protected void setupTestData() {
		RegistrationDaoFactory factory = RegistrationDaoFactory.getInstance();
		dao = factory.getAccountConfirmationDao();
		ac = QAccountConfirmation.accountConfirmation;
		
		accConfs = new AccountConfirmation[ACCOUNT_COUNT];
		for(int idx = 0; idx < ACCOUNT_COUNT; idx++) {
			accConfs[idx] = createAccountConf(idx);
		}
	}

	private AccountConfirmation createAccountConf(int idx) {
		AccountConfirmation accConf = new AccountConfirmation();
		accConf.setConfirmationAttempts(0);
		accConf.setCreateDate(new Date());
		accConf.setConfirmCode(SessionIdGenerator.getInstance().getRandomNumber(5));
		accConf.setConfirmSessionId(idx+"2347234jlswnwei879807sd832nk9wfw");
		
		return accConf;
	}
	
	public void testCRUD() throws DBConnectionException, InsertException,
			DatabaseException, SQLException {
		
		log("======== connection pool init =======");
		initConnPool();
		
		//dal insert
		log("======== DAL insert =======");
		insert();
		
		log("======== DAL find latest account confirmation =======");
		AccountConfirmation dbaccConf = 
				dao.findLatestAccountConfirmation(START_ACCOUNT_ID);
		log("DB account conf: " + dbaccConf.toString());
		
		log("======== DAL update attempts for one account =======");
		long id = dbaccConf.getId();
		dao.updateConfirmationAttempts(START_ACCOUNT_ID, id, 1);
		
		log("======== DAL insert one more for first account id =======");
		dao.insertAccountConfirmation(START_ACCOUNT_ID, accConfs[0]);
		
		log("======== DAL find latest account confirmation after new insert =======");
		dbaccConf = dao.findLatestAccountConfirmation(START_ACCOUNT_ID);
		log("DB account conf: " + dbaccConf.getCreateDate());
		
		
		log("======== DAL delete =======");
		long accNo = START_ACCOUNT_ID;
		int count = accConfs.length;
		for(int i=0; i<count; i++) {
			dao.deleteAccountConfirmation(accNo++);
		}
		log("******   TEST DONE!!!   ******");
	}

	private void insert() throws DBConnectionException, InsertException,
			DatabaseException {
		
		long aid = START_ACCOUNT_ID;
		for (AccountConfirmation aconf : accConfs) {
			dao.insertAccountConfirmation(aid++, aconf);
		}
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
	
	@Override
	protected void cleanup() {
		dao.cleanup();
	}

	private void log(String msg) {
		System.err.println(msg);
	}
}
