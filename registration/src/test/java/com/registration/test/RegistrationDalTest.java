package com.registration.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.registration.dal.bof.Description;
import com.vendertool.registration.dal.bof.DescriptionBo;

public class RegistrationDalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Description description = new Description();


		System.out.println("Transaction Began:");
		System.out.println("Description Dal Test Began !!!");
		description.setDescriptionCode(1);
		description.setDescriptionValue("test");
		description.setLanguageCode(1);
		

		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DescriptionBo descriptionBo = (DescriptionBo)appContext.getBean("descriptionBo");
		descriptionBo.insert(description);
		System.out.println("Description Dal Test Done !!!");
		descriptionBo.findByStockCode(null);
		

	}

}
