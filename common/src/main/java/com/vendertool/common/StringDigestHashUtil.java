package com.vendertool.common;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringDigestHashUtil {

	public static final int HEX_RADIX = 16;
	public static final String DIGEST = "SHA-256";
	public static final String UTF8 = "UTF-8";
	
	public static String sha256Hash(String input) {
		if((input == null) || (input.trim().isEmpty())) {
			return null;
		}
    	
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(DIGEST);
		} catch (NoSuchAlgorithmException ex) {
			md = null;
		}
		
		if(md == null) {
			return null;
		}
		
		try {
			md.update(input.getBytes(UTF8));
		} catch (UnsupportedEncodingException ueex) {
			return null;
		}
 
        byte[] byteData = md.digest();
    	
        BigInteger bigInt = new BigInteger(1, byteData);
        String digestHash = bigInt.toString(16);
        return digestHash;
	}
	
	public static void main(String[] args) {
		String test = "2013-07_SpreadMyInventory!";
		System.out.println("SHA-256 value of text '" + test + "' is \n\t" + sha256Hash(test));
	}
}

