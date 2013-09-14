package com.vendertool.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vendertool.common.SpringApplicationContextUtils;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = -6065436546520825860L;
	
	private static ApplicationContext ctx = SpringApplicationContextUtils.getApplicationContext();
	private static Credentials credentials = (Credentials) ctx.getBean("webserviceCredentials");
	private static final Logger logger = Logger.getLogger(CustomUserDetails.class);
	private static final String ROLE = "ROLE_INTERNAL";

	public Collection<? extends GrantedAuthority> getAuthorities() {
		logger.debug("Getting authorities");

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority role = new SimpleGrantedAuthority(ROLE);

        authorities.add(role);

        return authorities;
	}

	public String getPassword() {
		return credentials.getHashedpassword();
	}

	public String getUsername() {
		return credentials.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
	
	public String getPasswordSalt() {
		return credentials.getSalt();
	}

}
