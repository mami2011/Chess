package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.Account;

@XmlRootElement
public class UpdateAccountRequest extends BaseRequest {
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
