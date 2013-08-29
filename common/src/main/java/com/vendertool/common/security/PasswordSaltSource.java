package com.vendertool.common.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

public class PasswordSaltSource implements SaltSource {
	
	public Object getSalt(UserDetails user) {
		CustomUserDetails cud = (CustomUserDetails) user;
		return cud.getPasswordSalt();
	}
}