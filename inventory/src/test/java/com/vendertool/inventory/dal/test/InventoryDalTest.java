package com.vendertool.inventory.dal.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vendertool.inventory.dal.product.Product;
import com.vendertool.inventory.dal.product.ProductDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/dev/dal/Inventory.xml","classpath:config/dev/dal/DBConnectionConfig.xml" })
public class InventoryDalTest {

	@Autowired
	private ProductDaoImpl productDao;
	@Test
	public void addAccountTest() {
		Product product = new Product();

		product.setAvailbleQuantity(100);

		productDao.insert(product);

	}



}
