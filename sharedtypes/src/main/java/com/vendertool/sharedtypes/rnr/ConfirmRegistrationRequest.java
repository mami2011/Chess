package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.AccountConfirmation;

@XmlRootElement
public class ConfirmRegistrationRequest extends BaseRequest {
	private String emailId;
	private AccountConfirmation accountConf;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public AccountConfirmation getAccountConf() {
		return accountConf;
	}
	public void setAccountConf(AccountConfirmation accountConf) {
		this.accountConf = accountConf;
	}
	
}
