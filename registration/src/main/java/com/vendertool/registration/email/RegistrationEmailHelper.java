package com.vendertool.registration.email;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.vendertool.common.MsgSource;
import com.vendertool.common.SpringApplicationContextUtils;
import com.vendertool.common.URLConstants;
import com.vendertool.common.email.EmailDataModel;
import com.vendertool.common.email.VenderToolEmailService;
import com.vendertool.common.validation.ValidationUtil;
import com.vendertool.sharedtypes.core.Account;

public class RegistrationEmailHelper {
	private static final String PROPERTY_COMPANY_NAME = "email.company.name";
	private static final String PROPERTY_CONFIRM_REG_SUBJECT = "email.registration.confirmreg.subject";
	private static final String PROPERTY_REG_COMPLETE_SUBJECT = "email.registration.regcomplete.subject";
	
	private static ValidationUtil validationUtil = ValidationUtil.getInstance();
	private static final Logger logger = Logger.getLogger(RegistrationEmailHelper.class);
	private static RegistrationEmailHelper INSTANCE = null;
	
	private RegistrationEmailHelper() {
	}
	
	public synchronized static RegistrationEmailHelper getInstance() {
		if(validationUtil.isNull(INSTANCE)) {
			INSTANCE = new RegistrationEmailHelper();
		}
		return INSTANCE;
	}
	
	public void sendConfirmRegistrationEmail(Account account, String baseurl, Locale locale) {
		
		if (!isValid(account, baseurl)) {
			
			logger.debug("NO CONFIRM REG EMAIL SENT: 'Account' or 'base url' or 'account email' is null " +
					"while sending the confirm registration email");
			return;
		}
		
		MsgSource msgSource = new MsgSource();
		
    	ConfirmRegistrationEmailDataModel emailModel = new ConfirmRegistrationEmailDataModel();
    	emailModel.setToEmail(account.getEmailId());
		if (validationUtil.isNotNull(account.getContactDetails())
				&& (validationUtil.isNotNull(account.getContactDetails().getFirstName()))) {
			emailModel.setToName(account.getContactDetails().getFirstName());
		} else {
			emailModel.setToName(account.getEmailId());
		}
		emailModel.setFromName(msgSource.getMessage(PROPERTY_COMPANY_NAME, null,
				locale));
		emailModel.setSubject(msgSource.getMessage(PROPERTY_CONFIRM_REG_SUBJECT, null,
				locale));
    	
    	String emailId = account.getEmailId();
    	String sessiontoken = account.getAccountConf().getConfirmSessionId();
    	Integer confCode = account.getAccountConf().getConfirmCode();
    	
		String confirmRegUrl = baseurl + URLConstants.WEB_APP_PATH
				+ URLConstants.CONFIRM_ACCOUNT_PATH
				+ URLConstants.QUERY_PARAM_SEPARATOR + "email"
				+ URLConstants.VALUE_SEPARATOR + emailId
				+ URLConstants.FIELD_SEPARATOR + "sessiontoken"
				+ URLConstants.VALUE_SEPARATOR + sessiontoken
				+ URLConstants.FIELD_SEPARATOR + "confirmationcode"
				+ URLConstants.VALUE_SEPARATOR + confCode;
		
//		String encodedConfirmRegUrl = null;
//		
//		try {
//			encodedConfirmRegUrl = URLEncoder.encode(confirmRegUrl, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			logger.debug("UNABLE TO SEND EMAIL TO: '" + emailId + "'. Error msg: " + e.getMessage(), e);
//			return;
//		}
    	
    	emailModel.setConfirmationUrl(confirmRegUrl);
    	
    	ApplicationContext ctx = SpringApplicationContextUtils.getApplicationContext();
    	VenderToolEmailService emailService = (VenderToolEmailService) ctx.getBean("confirmRegistrationService");
    	emailService.sendEmail(emailModel, locale);
	}

	private boolean isValid(Account account, String baseurl) {
		return validationUtil.isNotNull(account) && validationUtil.isNotNull(baseurl)
				&& (!validationUtil.isEmpty(baseurl))
				&& validationUtil.isNotNull(account.getEmailId());
	}
	
	public void sendRegistrationCompleteEmail(Account account, String baseurl, Locale locale) {
		if (!isValid(account, baseurl)) {
			
			logger.debug("NO REG COMPLETE EMAIL SENT: 'Account' or 'base url' or 'account email' is null " +
					"while sending the registration complete email");
			return;
		}
		
		EmailDataModel emailModel = new EmailDataModel();
    	emailModel.setToEmail(account.getEmailId());
		if (validationUtil.isNotNull(account.getContactDetails())
				&& (validationUtil.isNotNull(account.getContactDetails().getFirstName()))) {
			emailModel.setToName(account.getContactDetails().getFirstName());
		} else {
			emailModel.setToName(account.getEmailId());
		}
		
		MsgSource msgSource = new MsgSource();
		
		emailModel.setFromName(msgSource.getMessage(PROPERTY_COMPANY_NAME, null,
				locale));
		emailModel.setSubject(msgSource.getMessage(PROPERTY_REG_COMPLETE_SUBJECT, null,
				locale));
		
    	ApplicationContext ctx = SpringApplicationContextUtils.getApplicationContext();
    	VenderToolEmailService emailService = (VenderToolEmailService) ctx.getBean("registrationCompleteService");
    	emailService.sendEmail(emailModel, locale);
	}
}
