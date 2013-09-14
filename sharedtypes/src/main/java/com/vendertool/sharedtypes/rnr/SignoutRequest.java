package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SignoutRequest extends BaseRequest {
	private String username;

	public String getUserName() {
		return username;
	}

	public void setUserName(String userLoginName) {
		this.username = userLoginName;
	}
}
