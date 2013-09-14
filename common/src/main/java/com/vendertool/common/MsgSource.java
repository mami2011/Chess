package com.vendertool.common;

import java.util.Locale;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.vendertool.common.validation.ValidationUtil;

/**
 * This is how you get access to resource like messages.properties 
 * from Java
 *
 */
public class MsgSource {
	@Autowired
	private MessageSource messageSource;
	
	private static ValidationUtil validationUtil = ValidationUtil.getInstance();
	private static final Logger logger = Logger.getLogger(MsgSource.class);
	
	private MessageSource getMessageSource() {
		WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();
		MessageSource ms = (MessageSource) webAppContext.getBean("messageSource");
		return ms;
	}
	
	/**
	 * This reads the message property value from messages.properties files (or any property file that is in the classpath)
	 * @param propertyName
	 */
	public String getMessage(String propertyName, Object[] args, Locale locale){
		if(validationUtil.isNull(propertyName)) {
			return null;
		}
		try {
			MessageSource ms = getMessageSource();
			return (ms != null) ? ms.getMessage(propertyName, args, locale) : null;
		} catch (NoSuchMessageException nsmex) {
			logger.log(Level.DEBUG, "No message found for property: " + propertyName, nsmex);
		}
		return null;
	}
}