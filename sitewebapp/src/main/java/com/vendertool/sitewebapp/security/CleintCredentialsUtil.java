package com.vendertool.sitewebapp.security;

import org.springframework.context.ApplicationContext;

import com.vendertool.sitewebapp.common.SpringApplicationContextUtils;

public class CleintCredentialsUtil {
	private static ApplicationContext ctx = SpringApplicationContextUtils
			.getApplicationContext();
	private static CleintCredentials credentials = (CleintCredentials) ctx
			.getBean("webserviceClientCredentials");

	public static CleintCredentials getClientCredentials() {
		return credentials;
	}
}
