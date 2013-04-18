package com.inventory.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.vendertool.inventory.dal.bof.MerchantProduct;
import com.vendertool.inventory.dal.bof.MerchantProductBo;

public class MerchantProductTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MerchantProduct product = new MerchantProduct();

		// TODO Auto-generated method stub
//		SessionFactory sf = new Configuration().configure("spring/config/BeanLocations.xml").buildSessionFactory();
//		Session session = sf.openSession();
//		session.beginTransaction();
		
	
		System.out.println("Transaction Began:");


		product.setProductId(26);
		product.setAvailableQuantity(100);
		product.setChangeWho("VenderToolTeam");
		product.setDescriptionId(1);
		product.setProductCode("1");
		product.setProductSKU("a");
		product.setProductTitle("My first product");



		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		MerchantProductBo stockBo = (MerchantProductBo)appContext.getBean("merchantProductBo");
		//MerchantProductBoImpl stockBo = new MerchantProductBoImpl();
//		MerchantProductDaoImpl merchantProductDao = new MerchantProductDaoImpl();
//		merchantProductDao.setSessionFactory(sf);
//		stockBo.setMerchantProductDao(merchantProductDao);

		stockBo.insert(product);
		System.out.println("Test it");
		stockBo.findByStockCode(null);
		

	}

}
