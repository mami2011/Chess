package com.vendertool.sharedtypes.core;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	private String emailId;
	private String password;
	private String confirmPassword;
	private String passwordSalt;
	private ContactDetails contact;
	private Date createDate;
	private Date validTillDate;
	private AccountRoleEnum role;
	private AccountStatusEnum accountStatus;
	private AccountConfirmation accountConf;
	
	public Account(){}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public ContactDetails getContact() {
		return contact;
	}

	public void setContact(ContactDetails contact) {
		this.contact = contact;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getValidTillDate() {
		return validTillDate;
	}

	public void setValidTillDate(Date validTillDate) {
		this.validTillDate = validTillDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public AccountRoleEnum getRole() {
		return role;
	}

	public void setRole(AccountRoleEnum role) {
		this.role = role;
	}

	public AccountStatusEnum getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatusEnum accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public AccountConfirmation getAccountConf() {
		return accountConf;
	}

	public void setAccountConf(AccountConfirmation accountConf) {
		this.accountConf = accountConf;
	}
}
