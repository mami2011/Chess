package com.vendertool.registration.dal.bof;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

public class Description implements Serializable {

	private int descriptionCode;
	private String descriptionValue;
	private int languageCode;
	private Date modifyDate;
	private String changeWho;
	private Date createDate;
	public int getDescriptionCode() {
		return descriptionCode;
	}
	public void setDescriptionCode(int descriptionCode) {
		this.descriptionCode = descriptionCode;
	}
	public String getDescriptionValue() {
		return descriptionValue;
	}
	public void setDescriptionValue(String descriptionValue) {
		this.descriptionValue = descriptionValue;
	}
	public int getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(int languageCode) {
		this.languageCode = languageCode;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
}
