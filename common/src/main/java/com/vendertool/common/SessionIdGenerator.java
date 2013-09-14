package com.vendertool.common;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class SessionIdGenerator {
	private static final int DEFAULT_RADIX = 32;
	private static final int DEFAULT_MAX_BIT_LENGTH = 130;
	
	private SecureRandom securerandom = null;
	private static Random random = null;

	private SessionIdGenerator() {
		securerandom = new SecureRandom();
		random = new Random();
	}
	
	private static class SessionIdGeneratorHolder {
		private static final SessionIdGenerator INSTANCE = new SessionIdGenerator();
	}
	
	public static SessionIdGenerator getInstance() {
		return SessionIdGeneratorHolder.INSTANCE;
	}
	
	public String generateSessionId(boolean hash){
		return generateSessionId(hash, DEFAULT_MAX_BIT_LENGTH, DEFAULT_RADIX);
	}
	
	public String generateSessionId(boolean hash, int bitLength, int radix){
		String randomString = generateSecureRandomId(bitLength, radix);
		if(hash) {
			return shaHash256(randomString);
		}
		return randomString;
	}
	
	public String shaHash256(String text) {
		if((text == null) || (text.isEmpty())) {
			return text;
		}
		
		return StringDigestHashUtil.sha256Hash(text);
	}
	
	/**
	 * The digit count range has to be between 0 to 9 since the return type is Integer. 
	 * The returned random Integer value will always be less than Integer.MAX_VALUE and greater than zero.
	 * 
	 * If the digit count is <= 0 or > 9, the default digit count of value 9 will be used.
	 * 
	 * @param digCount
	 * @return
	 */
	public Integer getRandomNumber(int digCount) {
		//Since we are using Integer as return value, the number of digits must be less than 10.
		//The reason being the number of digits for Integer.MAX_VALUE is 10
		if((digCount <= 0) || (digCount >= 9)) {
			digCount = 9;
		}
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++) {
	        sb.append((char)('0' + random.nextInt(10)));
	    }
	    return new Integer(sb.toString());
	}
	
	
	public String generateSecureRandomId(int numberOfBits, int radix) {
		if(numberOfBits <= 0) {
			numberOfBits = DEFAULT_MAX_BIT_LENGTH;
		}
		
		if(radix <= 0) {
			radix = DEFAULT_RADIX;
		}
		
		return new BigInteger(numberOfBits, securerandom).toString(radix);
	}
}