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
			System.out.println("MlCategories dal Test Began !!!");
			MlCategories mlCategories = new MlCategories();
			MlCategoriesDao mlCategoriesDao = (MlCategoriesDao) appContext.getBean("mlCategoriesDAO"); 
			//MlCategoriesDao.insert(MlCategories);
			mlCategories.setCategoryId(1);
			List<MlCategories> mlCategories1 =  mlCategoriesDao.findByCategoryId(mlCategories);
			System.out.println(mlCategories1.get(0).getMeliCategoryName());
		} finally {

		}
		try{
			System.out.println("MlCategoryAttributes dal Test Began !!!");
			MlCategoryAttributes mlCategoryAttributes = new MlCategoryAttributes();
			MlCategoryAttributesDao mlCategoryAttributesDao = (MlCategoryAttributesDao) appContext.getBean("mlCategoryAttributesDAO"); 
			//MlCategoryAttributesDao.insert(MlCategoryAttributes);
			mlCategoryAttributes.setCategoryId(1);
			List<MlCategoryAttributes> mlCategoryAttributes1 =  mlCategoryAttributesDao.findByAttributeId(mlCategoryAttributes);
			System.out.println(mlCategoryAttributes1.get(0).getMeliAttributeName());
		} finally {

		}
		try{
			System.out.println("MlCategoryAttributeValues dal Test Began !!!");
			MlCategoryAttributeValues mlCategoryAttributeValues = new MlCategoryAttributeValues();
			MlCategoryAttributeValuesDao mlCategoryAttributeValuesDao = (MlCategoryAttributeValuesDao) appContext.getBean("mlCategoryAttributeValuesDAO"); 
			//MlCategoryAttributeValuesDao.insert(MlCategoryAttributeValues);
			mlCategoryAttributeValues.setAttributeId(1);
			List<MlCategoryAttributeValues> mlCategoryAttributeValues1 =  mlCategoryAttributeValuesDao.findByAttributeValueId(mlCategoryAttributeValues);
			System.out.println(mlCategoryAttributeValues1.get(0).getMeliValueNameExtended());
		} finally {

		}


	}

}
