package com.vendertool.sitewebapp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Vender tools custom exception handling. We have to register this to the Dispatcher servlet vis bean def.
 * 
 *We can also implement springs SimpleMappingExceptionResolver if needed
 */
public class LoggingHandlerExceptionResolver implements
		HandlerExceptionResolver, Ordered {

	private static final Logger logger = Logger.getLogger(LoggingHandlerExceptionResolver.class);
	
	@Override
	public int getOrder() {
		//By this we get the first preference to handle the exception befores
		//spring's default exception handler kick's in
		return Integer.MIN_VALUE;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		if(ex == null) {
			return null;
		}
		
		logger.debug("UNEXPECTED EXCEPTION HAS OCCURRED: " + ex.getMessage(), ex);
		//return null when this occurred
		return null;
	}

}
