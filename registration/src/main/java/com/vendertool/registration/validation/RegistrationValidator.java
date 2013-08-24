package com.vendertool.registration.validation;

import org.apache.log4j.Logger;

import com.vendertool.common.validation.EmailRegexValidator;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.core.Account;
import com.vendertool.sharedtypes.error.Errors;
import com.vendertool.sharedtypes.exception.VTRuntimeException;
import com.vendertool.sharedtypes.rnr.BaseRequest;
import com.vendertool.sharedtypes.rnr.BaseResponse;
import com.vendertool.sharedtypes.rnr.RegisterAccountRequest;

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
	
	public void validate(BaseRequest _request, BaseResponse response) {
		RegisterAccountRequest request = (RegisterAccountRequest) _request;
		
		if (validationUtil.isNull(request)
				|| validationUtil.isNull(response)
				|| validationUtil.isNull(request.getAccount())
				|| validationUtil.isNull(request.getAccount()
						.getContactDetails())) {
			VTRuntimeException ex = new VTRuntimeException("NULL value passed to register an account");
			logger.debug("NULL value passed to register an account", ex);
			throw ex;
		}
		
		
		Account account = request.getAccount();
		validateName(account, response);
		validateEmail(account, response);
		validatePassword(account, response);
	}

	private void validateName(Account account, BaseResponse response) {
		//combine both errors together before returning
		if(validationUtil.isNullOrEmpty(account.getContactDetails().getFirstName())) {
			response.addFieldBindingError(
					Errors.REGISTRATION.MISSING_FIRSTNAME, 
					account.getContactDetails().getClass().getName(),
					"firstName");
		}
		
		if(validationUtil.isNullOrEmpty(account.getContactDetails().getLastName())) {
			response.addFieldBindingError(
					Errors.REGISTRATION.MISSING_LASTNAME,
					account.getContactDetails().getClass().getName(),
					"lastName");
		}
		
		return;
	}

	private void validatePassword(Account account, BaseResponse response) {
		String password = account.getPassword();
		String confirmPassword = account.getConfirmPassword();
		
		//First validate password field & then the confirm password
		if(validationUtil.isNullOrEmpty(password)) {
			response.addFieldBindingError(Errors.REGISTRATION.MISSING_PASSWORD, account.getClass().getName(), "password");
			return;
		}
		
		if(!validationUtil.checkStringSize(password, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH)) {
			response.addFieldBindingError(Errors.REGISTRATION.PASSWORD_LENGTH_INCORRECT, account.getClass().getName(), "password");
			return;
		}
		
		if(!validationUtil.matchesPattern(PASSWORD_REGEX, password)) {
			response.addFieldBindingError(Errors.REGISTRATION.INVALID_PASSWORD, account.getClass().getName(), "password");
			return;
		}
		
		//Now validate confirm password
		if(validationUtil.isNullOrEmpty(confirmPassword)) {
			response.addFieldBindingError(Errors.REGISTRATION.MISSING_CONFIRM_PASSWORD, account.getClass().getName(), "confirmPassword");
			return;
		}
		
		if(!password.equals(confirmPassword)) {
			response.addFieldBindingError(Errors.REGISTRATION.PASSWORD_CONFIRM_PASSWORD_MISMATCH, account.getClass().getName(), "confirmPassword");
			return;
		}
	}

	private void validateEmail(Account account, BaseResponse response) {
		if(validationUtil.isNullOrEmpty(account.getEmailId())) {
			response.addFieldBindingError(Errors.REGISTRATION.EMAIL_MISSING, account.getClass().getName(), "emailId");
			return;
		}
		
		if(!validationUtil.matchesPattern(EmailRegexValidator.SIMPLE_EMAIL_PATTERN, account.getEmailId())) {
			response.addFieldBindingError(Errors.REGISTRATION.INVALID_EMAIL_ID, account.getClass().getName(), "emailId");
		}
	}
}
