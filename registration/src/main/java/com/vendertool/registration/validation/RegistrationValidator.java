package com.vendertool.registration.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.EmailRegexValidator;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.error.VTError;
import com.vendertool.sharedtypes.rnr.RegisterAccountRequest;
import com.vendertool.sharedtypes.rnr.Request;

public class RegistrationValidator implements com.vendertool.common.validation.Validator {
	
	private static final Logger logger = Logger.getLogger(RegistrationValidator.class);
	private static ValidationUtil validationUtil = ValidationUtil.getInstance();
	private static int MIN_PASSWORD_LENGTH = 8;
	private static int MAX_PASSWORD_LENGTH = 25;
//	private static String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	//keep it simple for now (1 upper, 1 lower & a digit)
	private static String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,24}$";
	
	
	public RegistrationValidator() {
	}
	
	public List<VTError> validate(Request _request) {
		RegisterAccountRequest request = (RegisterAccountRequest) _request;
		
		List<VTError> errors = new ArrayList<VTError>();
		
		if(validationUtil.isNull(request) || validationUtil.isNull(request.getAccount())) {
			logger.debug("NULL value passed to register an account");
			errors.add(Errors.COMMON.NULL_ARGUMENT_PASSED);
			return errors;
		}
		
		Account account = request.getAccount();
		validateEmail(account.getEmailId(), errors);
		validatePassword(account.getPassword(), account.getConfirmPassword(), errors);
		return errors;
	}

	private void validatePassword(String password, String confirmPassword, List<VTError> errors) {
		//First validate password field & then the confirm password
		if(validationUtil.isNull(password)) {
			errors.add(Errors.REGISTRATION.MISSING_PASSWORD);
			return;
		}
		
		if(!validationUtil.checkStringSize(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
			errors.add(Errors.REGISTRATION.PASSWORD_LENGTH_INCORRECT);
			return;
		}
		
		if(!validationUtil.matchesPattern(PASSWORD_REGEX, password)) {
			errors.add(Errors.REGISTRATION.INVALID_PASSWORD);
			return;
		}
		
		//Now validate confirm password
		if(validationUtil.isNull(confirmPassword)) {
			errors.add(Errors.REGISTRATION.MISSING_CONFIRM_PASSWORD);
			return;
		}
		
		if(!password.equals(confirmPassword)) {
			errors.add(Errors.REGISTRATION.PASSWORD_CONFIRM_PASSWORD_MISMATCH);
			return;
		}
	}

	private void validateEmail(String emailId, List<VTError> errors) {
		if(validationUtil.isNull(emailId)) {
			errors.add(Errors.REGISTRATION.EMAIL_MISSING);
		}
		
		if(!validationUtil.matchesPattern(EmailRegexValidator.SIMPLE_EMAIL_PATTERN, emailId)) {
			errors.add(Errors.REGISTRATION.INVALID_EMAIL_ID);
		}
	}
}
