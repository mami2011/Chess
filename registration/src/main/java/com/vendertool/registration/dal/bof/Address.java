package com.vendertool.registration.dal.bof;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

public class Address implements Serializable {

	private int addressId;
	private int addressType;
	private int useCase;
	private String contactName;
	private String companyName;
	private String addrLn1;
	private String addrLn2;
	private String addrLn3;
	private String city;
	private String state;
	private String country;
	private String zip;
	private int sellerId;
	private int status;
	private Date createDate;
	private Date modifyDate;
	private String changeWho;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getAddressType() {
		return addressType;
	}
	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}
	public int getUseCase() {
		return useCase;
	}
	public void setUseCase(int useCase) {
		this.useCase = useCase;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddrLn1() {
		return addrLn1;
	}
	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}
	public String getAddrLn2() {
		return addrLn2;
	}
	public void setAddrLn2(String addrLn2) {
		this.addrLn2 = addrLn2;
	}
	public String getAddrLn3() {
		return addrLn3;
	}
	public void setAddrLn3(String addrLn3) {
		this.addrLn3 = addrLn3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
