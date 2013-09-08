package com.vendertool.common.test.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseDaoTest {

	public ApplicationContext context;
	
	protected BaseDaoTest() {
		initialize();
	}
	
	public void initialize() {
    	this.context = new ClassPathXmlApplicationContext("dal-module.xml");
    	setupTestData();
	}

	protected abstract void setupTestData();
	
	protected abstract void cleanup();

}
