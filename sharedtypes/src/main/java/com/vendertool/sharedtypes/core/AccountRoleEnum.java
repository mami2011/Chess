package com.vendertool.sharedtypes.core;

import com.vendertool.sharedtypes.exception.VTRuntimeException;

public enum AccountRoleEnum {
	ROLE_USER (1, "ROLE_USER_MASTER"),
	ROLE_USER_CHILD(2, "ROLE_USER_CHILD"),
	ROLE_ADMIN (3, "ROLE_ADMIN"), 
	ROLE_SYSTEM (4, "ROLE_SYSTEM");
	
	private int id;
	private String value;
	
	AccountRoleEnum(int id, String value) {
		if(contains(id)) {
			throw new VTRuntimeException("Duplicate enum id '" + 
							AccountRoleEnum.class.getName() + ".id=" + id + "'.");
		}
		this.id = id;
		this.value = value;
	}
	
	private boolean contains(int id) {
		AccountRoleEnum[] roles = values();
		for(AccountRoleEnum role : roles) {
			if(role.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}
}
