package com.vendertool.registration.dal.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

public static void main(String[] args) {
com.vendertool.registration.dal.account.Account accountDo = new com.vendertool.registration.dal.account.Account();
				//Set Do
				accountDo.setEmailAddr("muraliTest4@gmail");
				accountDo.setFirstName("murali2");
				accountDo.setLastName("BBB2");
				accountDo.setPassword("BBB2");
				
				@SuppressWarnings("resource")
				ApplicationContext appContext = 
						new ClassPathXmlApplicationContext("BeanLocations.xml");
				AccountDao accountDao = (AccountDao) appContext.getBean("accountDao"); 
				
				accountDao.insert(accountDo);
				//Insert into DB
				//AccountDaoImpl.getInstance().insert(accountDo);
				}
}
