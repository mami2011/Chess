package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SigninResponse extends BaseResponse {
	private String username;

	public String getUserName() {
		return username;
	}

	public void setUserName(String loginUserName) {
		this.username = loginUserName;
	}
}
