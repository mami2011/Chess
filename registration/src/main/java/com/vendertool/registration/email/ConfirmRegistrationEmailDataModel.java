package com.vendertool.registration.email;

import com.vendertool.common.email.EmailDataModel;

public class ConfirmRegistrationEmailDataModel extends EmailDataModel{

	private String confirmationUrl;

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public void setConfirmationUrl(String confirmationUrl) {
		this.confirmationUrl = confirmationUrl;
	}
}