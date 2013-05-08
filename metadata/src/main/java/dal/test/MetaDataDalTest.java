package dal.test;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dal.dao.*;;

public class MetaDataDalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("dal/resources/BeanLocations.xml");

		try{
			System.out.println("MercadolibreCategories dal Test Began !!!");
			MercadolibreCategories mercadolibreCategories = new MercadolibreCategories();
			MercadolibreCategoriesDao mercadolibreCategoriesDao = (MercadolibreCategoriesDao) appContext.getBean("mercadolibreCategoriesDAO"); 
			//mercadolibreCategoriesDao.insert(mercadolibreCategories);
			mercadolibreCategories.setCategoryId(1);
			List<MercadolibreCategories> mercadolibreCategories1 =  mercadolibreCategoriesDao.findByCategoryId(mercadolibreCategories);
			System.out.println(mercadolibreCategories1.get(0).getMeliCategoryName());
		} finally {

		}
		try{
			System.out.println("MercadolibreCategoryAttributes dal Test Began !!!");
			MercadolibreCategoryAttributes mercadolibreCategoryAttributes = new MercadolibreCategoryAttributes();
			MercadolibreCategoryAttributesDao mercadolibreCategoryAttributesDao = (MercadolibreCategoryAttributesDao) appContext.getBean("mercadolibreCategoryAttributesDAO"); 
			//mercadolibreCategoryAttributesDao.insert(mercadolibreCategoryAttributes);
			mercadolibreCategoryAttributes.setCategoryId(1);
			List<MercadolibreCategoryAttributes> mercadolibreCategoryAttributes1 =  mercadolibreCategoryAttributesDao.findByAttributeId(mercadolibreCategoryAttributes);
			System.out.println(mercadolibreCategoryAttributes1.get(0).getMeliAttributeName());
		} finally {

		}
		try{
			System.out.println("MercadolibreCategoryAttributeValues dal Test Began !!!");
			MercadolibreCategoryAttributeValues mercadolibreCategoryAttributeValues = new MercadolibreCategoryAttributeValues();
			MercadolibreCategoryAttributeValuesDao mercadolibreCategoryAttributeValuesDao = (MercadolibreCategoryAttributeValuesDao) appContext.getBean("mercadolibreCategoryAttributeValuesDAO"); 
			//mercadolibreCategoryAttributeValuesDao.insert(mercadolibreCategoryAttributeValues);
			mercadolibreCategoryAttributeValues.setAttributeId(1);
			List<MercadolibreCategoryAttributeValues> mercadolibreCategoryAttributeValues1 =  mercadolibreCategoryAttributeValuesDao.findByAttributeValueId(mercadolibreCategoryAttributeValues);
			System.out.println(mercadolibreCategoryAttributeValues1.get(0).getMeliValueNameExtended());
		} finally {

		}


	}

}
