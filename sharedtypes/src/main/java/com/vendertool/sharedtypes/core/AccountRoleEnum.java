package com.vendertool.sharedtypes.core;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AccountRoleEnum {
	ROLE_USER (1, "ROLE_USER_MASTER"),
	ROLE_USER_CHILD(2, "ROLE_USER_CHILD"),
	ROLE_ADMIN (3, "ROLE_ADMIN"), 
	ROLE_SYSTEM (4, "ROLE_SYSTEM");
	
	private int id;
	private String value;
	
	AccountRoleEnum(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}
	
	public static AccountRoleEnum get(int id) {
		AccountRoleEnum[] values = AccountRoleEnum.values();
		for(AccountRoleEnum e : values) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public static AccountRoleEnum get(String value) {
		if((value == null) || (value.trim().isEmpty())) {
			return null;
		}
		AccountRoleEnum[] values = AccountRoleEnum.values();
		for(AccountRoleEnum e : values) {
			if(e.getValue().equalsIgnoreCase(value)) {
				return e;
			}
		}
		return null;
	}
}
