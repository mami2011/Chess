package com.vendertool.registration.email;

import org.springframework.context.ApplicationContext;

import com.vendertool.common.SpringApplicationContextUtils;
import com.vendertool.common.URLConstants;
import com.vendertool.common.email.VenderToolEmailService;
import com.vendertool.sharedtypes.core.Account;

public class RegistrationEmailHelper {
	public static void sendRegistrationEmail(Account account, String baseurl) {
		if((account == null) || (baseurl == null)){
			return;
		}
		
    	RegistrationEmailDataModel emailModel = new RegistrationEmailDataModel();
    	emailModel.setToEmail("Girish.Kodaganti@gmail.com");
    	emailModel.setToName("Kodaganti");
    	emailModel.setFromName("VTool Team");
    	emailModel.setSubject("Vender Tool Registration");
    	
    	String emailId = account.getEmailId();
    	String sessiontoken = account.getAccountConf().getConfirmSessionId();
    	Integer confCode = account.getAccountConf().getConfirmCode();
    	
    	String confirmUrl = baseurl + URLConstants.PATH_SEPARATOR +
    			URLConstants.WEB_APP_PATH + URLConstants.CONFIRM_ACCOUNT_PATH + URLConstants.QUERY_PARAM_SEPARATOR
    			+ "email" + URLConstants.VALUE_SEPARATOR + emailId
    			+ "sessiontoken" + URLConstants.VALUE_SEPARATOR + sessiontoken
    			+ "confirmationcode" + URLConstants.VALUE_SEPARATOR + confCode;
    	
    	emailModel.setConfirmationUrl(confirmUrl);
    	
    	ApplicationContext ctx = SpringApplicationContextUtils.getApplicationContext();
    	VenderToolEmailService emailService = (VenderToolEmailService) ctx.getBean("registrationService");
    	emailService.sendEmail(emailModel);
	}
}
