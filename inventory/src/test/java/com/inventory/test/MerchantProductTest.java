package com.inventory.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.inventory.DBL.MerchantProduct;
import com.vendertool.inventory.DBL.MerchantProductBo;

public class MerchantProductTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MerchantProduct product = new MerchantProduct();
		
		// TODO Auto-generated method stub
			SessionFactory sf = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			System.out.println("Transaction Began:");
			
		
		product.setProductId(3);
		product.setAvailableQuantity(100);
		product.setChangeWho("VenderToolTeam");
		product.setDescriptionId(1);
		product.setProductCode("1");
		product.setProductSKU("a");
		product.setProductTitle("My first listing");
		
		
		
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
  	MerchantProductBo stockBo = (MerchantProductBo)appContext.getBean("merchantProductBo");
		
  	stockBo.save(product);
		System.out.println("Test it");

	}

}
