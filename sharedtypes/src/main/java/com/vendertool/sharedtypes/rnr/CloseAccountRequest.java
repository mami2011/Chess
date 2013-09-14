package com.vendertool.sharedtypes.rnr;

import javax.xml.bind.annotation.XmlRootElement;

import com.vendertool.sharedtypes.core.AccountClosureReasonCodeEnum;

@XmlRootElement
public class CloseAccountRequest extends BaseRequest {
	private String username;
	private AccountClosureReasonCodeEnum reasonCode;
	private String reasonMessage;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public AccountClosureReasonCodeEnum getReasonCode() {
		return reasonCode;
	}
	
	public void setReasonCode(AccountClosureReasonCodeEnum reasonCode) {
		this.reasonCode = reasonCode;
	}
	
	public String getReasonMessage() {
		return reasonMessage;
	}
	
	public void setReasonMessage(String reasonMessage) {
		this.reasonMessage = reasonMessage;
	}
}
