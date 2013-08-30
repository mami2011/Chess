package com.vendertool.registration.dal.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vendertool.registration.dal.account.Account;
import com.vendertool.registration.dal.account.AccountDao;
import com.vendertool.registration.dal.account.AccountDaoImpl;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmation;
import com.vendertool.registration.dal.accountConfirmation.AccountConfirmationDaoImpl;
import com.vendertool.registration.dal.address.Address;
import com.vendertool.registration.dal.address.AddressDao;
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
		//accountDao.insert(account);
		Long i = accountDao.getNextValue();
		System.out.println("Next value " + i);
		
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
