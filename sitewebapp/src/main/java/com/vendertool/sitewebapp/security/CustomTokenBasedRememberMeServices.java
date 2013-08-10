package com.vendertool.sitewebapp.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

import com.vendertool.sitewebapp.common.ContainerBootstrapContext;
import com.vendertool.sitewebapp.common.EnvironmentEnum;

public class CustomTokenBasedRememberMeServices extends
		TokenBasedRememberMeServices {
		
    public CustomTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
    }
	
    
	protected EnvironmentEnum getEnvironment() {
		return ContainerBootstrapContext.getContext().getEnvironment();
	}
	
	/*
	 * We use this if we want to add user IP to the remember-me token
	 */
	protected String getUserIPAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}
	
	/**
	 * We do this to avoid the remember-me token being the same for different environment
	 */
	@Override
	protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
		return DigestUtils
				.md5DigestAsHex((username + ":" + tokenExpiryTime + ":"
						+ password + ":" + getKey() + ":" + getEnvironment().getName())
						.getBytes()); 
	}
	
	
	@Override
	protected void setCookie(String[] tokens, int maxAge,
			HttpServletRequest request, HttpServletResponse response) {
		
	  String[] tokensWithEnv = Arrays.copyOf(tokens, tokens.length+1);
	  tokensWithEnv[tokensWithEnv.length-1] = getEnvironment().getName();
	  super.setCookie(tokensWithEnv, maxAge, request, response);
	}
	
	
	@Override
	protected UserDetails processAutoLoginCookie(String[] cookieTokens,
			HttpServletRequest request, HttpServletResponse response) 
	{
	    String envToken = cookieTokens[cookieTokens.length-1];
	    if(!getEnvironment().getName().equals(envToken))
	    {
			throw new InvalidCookieException(
					"Remember-me: Environment cookie token did not contain a matching value. " +
					"Contained cookie env value is '"
							+ envToken + "')");
	    }
	      
	    return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length-1), request, response);
	}
}