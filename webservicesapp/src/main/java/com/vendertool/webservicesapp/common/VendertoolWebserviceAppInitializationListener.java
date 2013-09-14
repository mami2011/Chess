package com.vendertool.webservicesapp.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class VendertoolWebserviceAppInitializationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		ContainerBootstrapContext.createContext(servletContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ContainerBootstrapContext.getContext().clearContext();		
	}
}