package com.vendertool.registration.dal.bof;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

public class Account implements Serializable {

	private int accountId;
	private String emailAddr;
	private String password;
	private Date accountExpDate;
	private int registrationAddrId;
	private int shipFromAddrId;
	private int returnAddrId;
	private String firstName;
	private String lastName;
	private String middleName;
	private int state;
	private int registrationCountry;
	private int sellerlanguage;
	private Date createDate;
	private Date modifyDate;
	private String changeWho;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getAccountExpDate() {
		return accountExpDate;
	}
	public void setAccountExpDate(Date accountExpDate) {
		this.accountExpDate = accountExpDate;
	}
	public int getRegistrationAddrId() {
		return registrationAddrId;
	}
	public void setRegistrationAddrId(int registrationAddrId) {
		this.registrationAddrId = registrationAddrId;
	}
	public int getShipFromAddrId() {
		return shipFromAddrId;
	}
	public void setShipFromAddrId(int shipFromAddrId) {
		this.shipFromAddrId = shipFromAddrId;
	}
	public int getReturnAddrId() {
		return returnAddrId;
	}
	public void setReturnAddrId(int returnAddrId) {
		this.returnAddrId = returnAddrId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getRegistrationCountry() {
		return registrationCountry;
	}
	public void setRegistrationCountry(int registrationCountry) {
		this.registrationCountry = registrationCountry;
	}
	public int getSellerlanguage() {
		return sellerlanguage;
	}
	public void setSellerlanguage(int sellerlanguage) {
		this.sellerlanguage = sellerlanguage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getChangeWho() {
		return changeWho;
	}
	public void setChangeWho(String changeWho) {
		this.changeWho = changeWho;
	}

	
	
}
