package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Signin;

@XmlRootElement
public class SigninRequest extends BaseRequest {
	private Signin signin;

	public Signin getSignin() {
		return signin;
	}

	public void setSignin(Signin signin) {
		this.signin = signin;
	}
}
