package com.dal.test;

import java.util.List;


import org.hibernate.FlushMode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dal.dao.Account;
import com.dal.dao.AccountDao;
import com.dal.dao.Address;
import com.dal.dao.AddressDao;


public class DalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("com/dal/resources/BeanLocations.xml");
		
		try{
			System.out.println("Address dal Test Began !!!");
			Address address = new Address();
			AddressDao addressDao = (AddressDao) appContext.getBean("addressDAO"); 
			
			//Insert address object 
			/*address.setAddressId((long) 29);
			address.setContactFirstName("Murali123");
			addressDao.insert(address,FlushMode.COMMIT);
			addressDao.insert(address,FlushMode.AUTO);*/
			
			Address address2 = new Address();
			address2.setAddressId((long) 26);
			List<Address> address1 =  addressDao.findByAddressId(address2);
			System.out.println(address1.get(0).getContactFirstName());
		} finally {

		}
		
		try{
			System.out.println("Account dal Test Began !!!");
			Account account = new Account();
			AccountDao accountDao = (AccountDao) appContext.getBean("accountDAO"); 
			
			//Inser Account object
			/*account.setAccountId((long) 29);
			account.setFirstName("Murali");
			account.setLastName("Beedala");
			account.setBillingAddrId(1);
			account.setRegistrationAddrId(1);
			accountDao.insert(account);*/
			
			account.setAccountId((long) 1);
			List<Account> account1 =  accountDao.findByAccountId(account);
			System.out.println(account1.get(0).getFirstName());
			//System.out.println(account1.get(0).getLastName());
		} finally {

		}
		
		
		

	}

}
