package com.vendertool.registration.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;

import com.vendertool.sharedtypes.core.Account;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, Object>{
	private static final Logger logger = Logger.getLogger(ConfirmPasswordValidator.class);
	
//    private String passwordFieldName;
//    private String confirmPasswordFieldName;

//    @Override
    public void initialize(final ConfirmPassword constraintAnnotation)
    {
//    	passwordFieldName = constraintAnnotation.passwordFieldName();
//    	confirmPasswordFieldName = constraintAnnotation.confirmPasswordFieldName();
    }

//    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
    	if((value == null) || !(value instanceof Account)) {
    		logger.debug("ConfirmPasswordValidator isValid method's object is either null or of instance other than Account");
    		return false;
    	}
    	
    	Account account = (Account) value;
    	String pwd = account.getPassword();
    	String confirmPwd = account.getConfirmPassword();
    	
        return (((pwd == null) && (confirmPwd == null)) || 
        			((pwd != null) && (pwd.equals(confirmPwd))));
    }
}
