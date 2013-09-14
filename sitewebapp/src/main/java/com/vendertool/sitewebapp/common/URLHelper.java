package com.vendertool.sitewebapp.common;

import javax.servlet.http.HttpServletRequest;

public class URLHelper {
	
	private static String baseUrl;
	
	static {
		HttpServletRequest req = ContainerBootstrapContext.getHttpServletRequest();
		ContainerBootstrapContext ctx = ContainerBootstrapContext.getContext();
		EnvironmentEnum env = ctx.getEnvironment();
		
		System.err.println("req.getRemoteAddr():" + req.getRemoteAddr());
	
		baseUrl = RestServiceClientHelper.getServerURL(req);
		
		if (env == EnvironmentEnum.DEVELOPMENT) {
			baseUrl += "/site/";
		}
		else {
			baseUrl += "/";
		}
	}
	
	public static String getHomeUrl() {
		return baseUrl + URLConstants.HOME;
	}
	
	public static String getProfileUrl() {
		return baseUrl + URLConstants.PROFILE;
	}
	
	public static String getAccountHubUrl() {
		return baseUrl + URLConstants.ACCOUNT_HUB;
	}
	
	public static String getUploadsUrl() {
		return baseUrl + URLConstants.UPLOADS;
	}
}
