package com.vendertool.registration.dal.account;

public class UpdateSet extends BaseFieldSet {
	private static class UpdateSetHolder {
		private static final UpdateSet INSTANCE = new UpdateSet();
	}
	
	public static UpdateSet getInstance() {
		return UpdateSetHolder.INSTANCE;
	}
	
	public static final AccountFieldEnum[] ALL = BaseFieldSet.ALL;
	
	public static final AccountFieldEnum[] EMAIL = { 
		AccountFieldEnum.EMAIL_ID,
		AccountFieldEnum.STATUS, 
		AccountFieldEnum.LAST_MOD_APP,
		AccountFieldEnum.LAST_MOD_DATE
	};
	
	public static final AccountFieldEnum[] PASSWORD = {
		AccountFieldEnum.STATUS, 
		AccountFieldEnum.PASSWORD,
		AccountFieldEnum.LAST_MOD_APP,
		AccountFieldEnum.LAST_MOD_DATE
	};
	
	public static final AccountFieldEnum[] PROFILE = { 
		AccountFieldEnum.STATUS, 
		AccountFieldEnum.PASSWORD,
		AccountFieldEnum.LAST_MOD_APP,
		AccountFieldEnum.LAST_MOD_DATE, 
		AccountFieldEnum.ALTERNATE_EMAIL_ID,
		AccountFieldEnum.BILLING_ADDR_ID,
		AccountFieldEnum.CURRENCY_CODE, 
		AccountFieldEnum.FIRST_NAME,
		AccountFieldEnum.LAST_NAME,
		AccountFieldEnum.MIDDLE_NAME,
		AccountFieldEnum.LANGUAGE,
		AccountFieldEnum.PICTURE,
		AccountFieldEnum.REG_ADDR_ID
	};
	
}
