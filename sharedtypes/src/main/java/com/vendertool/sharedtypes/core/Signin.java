package com.vendertool.sharedtypes.core;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@XmlAccessorType(XmlAccessType.FIELD)
public class Signin {
	@NotNull
	@Email
	@NotEmpty
	String username;
	
	@NotNull
	String password;
	
//	@Pattern(regexp ="^[a-zA-Z0-9-_]*$")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
