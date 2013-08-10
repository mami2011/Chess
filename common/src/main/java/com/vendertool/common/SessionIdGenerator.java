package com.vendertool.common;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SessionIdGenerator {
	private static final int RADIX = 32;
	private static final int MAX_BIT_LENGTH = 130;
	private static SessionIdGenerator INSTANCE = null;
	
	private SecureRandom random = null;

	private SessionIdGenerator() {
		random = new SecureRandom();
	}
	
	public static synchronized SessionIdGenerator getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SessionIdGenerator();
		}
		
		return INSTANCE;
	}
	
	public String generateSessionId(boolean hash){
		String randomString = new BigInteger(MAX_BIT_LENGTH, random).toString(RADIX);
		if(hash) {
			return StringDigestHashUtil.sha256Hash(randomString);
		}
		return randomString;
	}
}
