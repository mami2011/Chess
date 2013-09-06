package com.vendertool.registration.dal;

import com.vendertool.sharedtypes.core.Account;

public class RegistrationDALService {
	
	private RegistrationDALService() {
	}
	
	private static class RegistrationDALServiceHolder {
		private static final RegistrationDALService INSTANCE = new RegistrationDALService();
	}
	
	public static RegistrationDALService getInstance() {
		return RegistrationDALServiceHolder.INSTANCE;
	}
	
	public void registerAccount(Account account) {
		
	}
	
	public void changeAccountProfile(Account account) {
		
	}
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		
	}
	
	public void changeEmail(String oldEmail, String newEmail) {
		
	}
	
	public Account getAccountDetails(String email) {
		return null;
	}
	
	public boolean isPreviouslyUsedPassword(String hashedPassword) {
		return false;
	}
	
//	public List<AccountSecurityQuestion> getAccountSecurityQuestions(String email) {
//		
//	}
//	
//	public void updateAccountSecurityQuestions(String email, List<AccountSecurityQuestion>) {
//		
//	}
}
