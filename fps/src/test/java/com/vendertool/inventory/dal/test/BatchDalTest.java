package com.vendertool.inventory.dal.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vendertool.fps.dal.file.File;
import com.vendertool.fps.dal.file.FileDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/dev/dal/Inventory.xml","classpath:config/dev/dal/DBConnectionConfig.xml" })
public class BatchDalTest {

	@Autowired
	private FileDaoImpl fileDao;
	@Test
	public void addAccountTest() {
		File file = new File();

		file.setAccountId(1);
		file.setFileId(101);
		file.setFileGroupId("myfirstfile");
		
		fileDao.insert(file);

	}



}
