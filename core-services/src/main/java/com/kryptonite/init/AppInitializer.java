package com.kryptonite.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Starting init....");
		
		DBInitializer.initDb();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Stopping init....");
		
		DBInitializer.shutdownDb();
	}
	
} 