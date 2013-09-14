package com.vendertool.common.security;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if((username == null) || (username.trim().isEmpty())) {
			UsernameNotFoundException ex =  new UsernameNotFoundException("Username cannot be empty");
			logger.log(Level.DEBUG, "Username cannot be empty", ex);
			throw ex;
		}
		
		UserDetails ud = new CustomUserDetails();
		String un = ud.getUsername();
		if(!username.equals(un)) {
			UsernameNotFoundException ex = new UsernameNotFoundException("Invalid username or password");
			logger.log(Level.DEBUG, "Invalid username or password", ex);
			throw ex;
		}
		
		return ud;
	}

}