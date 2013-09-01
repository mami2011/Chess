package com.vendertool.registration.dal.account;

public class ReadSet extends BaseFieldSet {
	private static class ReadSetHolder {
		private static final ReadSet INSTANCE = new ReadSet();
	}
	
	public static ReadSet getInstance() {
		return ReadSetHolder.INSTANCE;
	}
	
	public static final AccountFieldEnum[] ALL = BaseFieldSet.ALL;
	
	public static final AccountFieldEnum[] MEDIUM = { 
		AccountFieldEnum.ACCOUNT_ID,
		AccountFieldEnum.EMAIL_ID,
		AccountFieldEnum.FIRST_NAME,
		AccountFieldEnum.LAST_NAME,
		AccountFieldEnum.MIDDLE_NAME,
		AccountFieldEnum.LANGUAGE,
		AccountFieldEnum.STATUS
	};
	
	public static final AccountFieldEnum[] MINIMUM = {
		AccountFieldEnum.ACCOUNT_ID,
		AccountFieldEnum.EMAIL_ID,
		AccountFieldEnum.STATUS
	};
	
	public static final AccountFieldEnum[] PASSWORD_SPECIFIC = {
		AccountFieldEnum.ACCOUNT_ID,
		AccountFieldEnum.EMAIL_ID,
		AccountFieldEnum.STATUS, 
		AccountFieldEnum.PASSWORD,
		AccountFieldEnum.ROLES,
		AccountFieldEnum.SALT,
	};
}
