package com.vendertool.sharedtypes.core;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccountConfirmation {
	private Long id;
	private String confirmSessionId;
	private Integer confirmCode;
	private int confirmationAttempts;
	private Date confirmationDate;
	private Date createDate;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmSessionId() {
		return confirmSessionId;
	}
	public void setConfirmSessionId(String confirmSessionId) {
		this.confirmSessionId = confirmSessionId;
	}
	public Integer getConfirmCode() {
		return confirmCode;
	}
	public void setConfirmCode(Integer confirmCode) {
		this.confirmCode = confirmCode;
	}
	public int getConfirmationAttempts() {
		return confirmationAttempts;
	}
	
	public void incrementAttempts() {
		confirmationAttempts++;
	}

	public void setConfirmationAttempts(int confirmationAttempts) {
		this.confirmationAttempts = confirmationAttempts;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
