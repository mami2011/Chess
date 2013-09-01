package com.vendertool.registration.dal.account;

import com.vendertool.common.validation.ValidationUtil;

public enum AccountFieldEnum {
	UNKNOWN("UNKNOWN"),
	ACCOUNT_ID("accountId"),
	EMAIL_ID("emailAddr"),
	ALTERNATE_EMAIL_ID("alternateEmail"),
	PASSWORD("password"),
	SALT("salt"),
	FIRST_NAME("firstName"),
	LAST_NAME("lastName"),
	MIDDLE_NAME("middleName"),
	PICTURE("picture"),
	REG_ADDR_ID("registrationAddrId"),
	BILLING_ADDR_ID("billingAddrId"),
	STATUS("status"),
	LANGUAGE("language"),
	CURRENCY_CODE("currencyCodeIso3"),
	ROLES("roles"),
	CREATED_DATE("createdDate"),
	LAST_MOD_DATE("lastModifiedDate"),
	LAST_MOD_APP("lastModifiedApp");
	
	private String fieldId;
	
	private AccountFieldEnum(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldId() {
		return fieldId;
	}
	
	public static AccountFieldEnum get(String fid) {
		if(ValidationUtil.getInstance().isEmpty(fid)) {
			return UNKNOWN;
		}
		
		AccountFieldEnum[] fieldNames = AccountFieldEnum.values();
		for(AccountFieldEnum fn : fieldNames) {
			fn.getFieldId().equalsIgnoreCase(fid);
			return fn;
		}
		
		return UNKNOWN;
	}
	
}
