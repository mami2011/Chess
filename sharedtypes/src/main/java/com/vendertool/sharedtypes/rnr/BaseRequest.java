package com.vendertool.sharedtypes.rnr;

public class BaseRequest implements Request {

	private String emailId;

	public BaseRequest(){}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
