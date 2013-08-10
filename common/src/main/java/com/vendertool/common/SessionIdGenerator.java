package com.vendertool.common;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class SessionIdGenerator {
	private static final int RADIX = 32;
	private static final int MAX_BIT_LENGTH = 130;
	private static SessionIdGenerator INSTANCE = null;
	
	private SecureRandom random = null;
	private static Random rnd = new Random();

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
	
	public Integer getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++) {
	        sb.append((char)('0' + rnd.nextInt(10)));
	    }
	    return new Integer(sb.toString());
	}
}
