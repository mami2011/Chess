package com.vendertool.emailapp.datamodel;

public class RegistrationEmailDataModel extends EmailDataModel{

	private String confirmationCode;

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
}