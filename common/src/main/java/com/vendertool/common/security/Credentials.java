package com.vendertool.common.security;

public class Credentials {
	private String username;
	private String hashedpassword;
	private String salt;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHashedpassword() {
		return hashedpassword;
	}
	
	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
