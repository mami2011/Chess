package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChangeEmailRequest extends BaseRequest {
	private String oldEmailId;
	private String newEmail;
	private String confirmEmail;
	private String password;
	
	public String getOldEmailId() {
		return oldEmailId;
	}
	
	public void setOldEmailId(String oldEmailId) {
		this.oldEmailId = oldEmailId;
	}
	
	public String getNewEmail() {
		return newEmail;
	}
	
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	
	public String getConfirmEmail() {
		return confirmEmail;
	}
	
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
