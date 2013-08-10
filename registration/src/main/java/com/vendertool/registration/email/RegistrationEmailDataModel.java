package com.vendertool.registration.email;

import com.vendertool.common.email.EmailDataModel;

public class RegistrationEmailDataModel extends EmailDataModel{

	private String confirmationCode;

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
}