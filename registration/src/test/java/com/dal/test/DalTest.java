package com.dal.test;

import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vendertool.registration.dal.account.deprecate.Account;
import com.vendertool.registration.dal.account.deprecate.AccountDaoImpl;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmation;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmationDaoImpl;
import com.vendertool.registration.dal.address.Address;
import com.vendertool.registration.dal.address.AddressDaoImpl;
import com.vendertool.registration.dal.passwordHistory.PasswordHistory;
import com.vendertool.registration.dal.passwordHistory.PasswordHistoryDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/dev/dal/Registration.xml","classpath:config/dev/dal/DBConnectionConfig.xml" })
public class DalTest {
	
	@Autowired
	private AccountDaoImpl accountDao;
	@Test
	public void addAccountTest() {
		Account account = new Account();
		
		//account.setAccountId((long) 101);
		account.setEmailAddr("tesst2@gmail.com");
		account.setFirstName("test");
		account.setPassword("test");
		account.setSalt("salt");
		try {
//			accountDao.insert(account);
			ClassMetadata cmd = accountDao.getSessionFactory().getClassMetadata(account.getClass().getName());
			System.err.println(cmd.getPropertyNames());
			System.err.println(cmd);
			AbstractEntityPersister persister = (AbstractEntityPersister)cmd;
			System.err.println(persister.getPropertyColumnNames("alternateEmail")[0]);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	//	Long i = accountDao.getNextValue();
		//System.out.println("Next value " + i);
		
	}
	
	//AccountConfirmationTest
	@Autowired
	private AccountConfirmationDaoImpl accountConfirmationDao;
	//@Test
	public void addAccountConfirmationTest() {
		AccountConfirmation accountConfirmation = new AccountConfirmation();
		
		accountConfirmation.setAccountId((long) 101);
		accountConfirmation.setNumberOfAttempts((byte) 2);
		accountConfirmationDao.insert(accountConfirmation);
		
	}
	
	//Address 
	@Autowired
	private AddressDaoImpl addressDao;
//	@Test
	public void addAddressTest() {
		Address address = new Address();
		
		address.setAddrLn1("test ln1");
		address.setAddrLn2("test ln2");
		address.setCity("test city");
		address.setState("test state");
		
		addressDao.insert(address);
		
	}
	
	//password_history 
		@Autowired
		private PasswordHistoryDaoImpl passwordHistoryDao;
//		@Test
		public void addPasswordHistoryTest() {
			PasswordHistory passwordHistory = new PasswordHistory();
			
			passwordHistory.setAccountId(101L);
			passwordHistory.setPassword("test password");
			passwordHistory.setPassswordHistoryId(1L);
			
			passwordHistoryDao.insert(passwordHistory);
			
		}

}
