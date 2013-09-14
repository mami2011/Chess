package com.vendertool.sitewebapp.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;


public class PasswordSaltSource implements SaltSource {

	@Override
	public Object getSalt(UserDetails user) {
		CustomUserDetails cud = (CustomUserDetails) user;
		return cud.getPasswordSalt();
	}

}
