package com.vendertool.productload;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

import com.dal.dao.MerchantProduct;
import com.dal.dao.MerchantProductDao;
import com.dal.dao.ProductVariation;
import com.dal.dao.ProductVariationDao;
import com.vendertool.sharedtypes.core.ApplicationEnum;
import com.vendertool.sharedtypes.core.ProductCodeTypeEnum;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("productreader")
public class ProductReader implements ItemReader<String> {

	//Read CSV file .

	static String csvFilename = "C:\\1vtool\\Batch\\FileSpec\\testfile1.csv";
	static FileReader reader;
	MerchantProduct product = new MerchantProduct();
	ProductVariation productVariation = new ProductVariation();
	static{
		try {
			reader = new FileReader(csvFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	CSVReader csvReader = new CSVReader(reader);

	public int readFile() {
		String[] row = new String[20];
		int status = 0;

		try {
			while((row = csvReader.readNext()) != null) {
				//insert in product table , if product don't exist  .
				ApplicationContext appContext = 
						new ClassPathXmlApplicationContext("com/dal/resources/BeanLocations.xml");
				MerchantProductDao merchantProductDao = (MerchantProductDao) appContext.getBean("merchantProductDao");
				List <MerchantProduct> merchantProduct = merchantProductDao.findByAccountIdAndSKU(101, row[0]);
				if(merchantProduct.size()== 0){
					//create new product
					writeToProductDB(row);
				} 
				//create variations 
				if(row.length>12) {
					writeToVariationsDB( row);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//...
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(0);
	}

	@Override
	public String read() throws Exception, UnexpectedInputException,
	ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		readFile();
		return null;
	}
	private int writeToProductDB(String[] row) {

		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("com/dal/resources/BeanLocations.xml");
		MerchantProductDao merchantProductDao = (MerchantProductDao) appContext.getBean("merchantProductDao");
		merchantProductDao.insert(product);


		//seqnum merchantProductId
		product.setTitle(row[3]);
		product.setSku(row[0]);
		//Account id need to read from login credentials
		product.setAccountId((long) 101);
		product.setProductCode(row[1]);
		product.setProductCodeType((byte)ProductCodeTypeEnum.valueOf(row[2]).getId());
		product.setAvailableQuantity(Integer.getInteger(row[7]));
		BigDecimal big = new BigDecimal(row[5]);
		product.setPrice(big);
		product.setLastModifiedApp((byte)ApplicationEnum.valueOf("BATCH").getId());
		return(0);
	}

	private int writeToVariationsDB(String[] row) {

		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("com/dal/resources/BeanLocations.xml");
		MerchantProductDao merchantProductDao = (MerchantProductDao) appContext.getBean("merchantProductDao");
		ProductVariationDao productVariationDao = (ProductVariationDao) appContext.getBean("productVariationDao"); 

		List <MerchantProduct> myProduct = merchantProductDao.findByAccountIdAndSKU(101, product.getSku());
		for ( int collen=12 ; collen < row.length ; collen=collen+2)
			//insert in variation table
			if (row[collen] != null &&row[collen+1] != null) {
				//insert variation , if the variation value not exist 
				List <ProductVariation> myProductVariation = productVariationDao.findByProductIdAndVariationName(myProduct.get(0).getMerchantProductId(), row[collen]);
				if (myProductVariation.size() == 0) {
					productVariation.setProductId(myProduct.get(0).getMerchantProductId());
					productVariation.setSku(product.getSku());
					productVariation.setAvailbleQuantity(product.getAvailableQuantity());
					productVariation.setPrice(product.getPrice());
					productVariation.setTitle(product.getTitle());
					productVariation.setVariationName(row[collen]);
					productVariation.setVariationValue(row[collen+1]);

					//insert into product variations

					productVariationDao.insert(productVariation);

				} else {
					//Variation exist 
				}

			} else {
				//incorrect variation data
			}
		return(0);
	}


}
