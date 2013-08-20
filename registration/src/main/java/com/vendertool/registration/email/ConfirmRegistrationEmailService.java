package com.vendertool.registration.email;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.vendertool.common.MsgSource;
import com.vendertool.common.email.EmailDataModel;
import com.vendertool.common.email.VenderToolEmailService;
import com.vendertool.common.validation.ValidationUtil;

public class ConfirmRegistrationEmailService extends VenderToolEmailService {
	private static final Logger logger = Logger.getLogger(ConfirmRegistrationEmailService.class);
	private static ValidationUtil validationUtil = ValidationUtil.getInstance();
	private static String UTF8 = "UTF-8";

	@Override
	public void sendEmail(EmailDataModel _dataModel, final Locale locale) {
		if(validationUtil.isNull(_dataModel) || (!(_dataModel instanceof ConfirmRegistrationEmailDataModel))) {
			logger.debug("email data model is null or is not instance of " + ConfirmRegistrationEmailDataModel.class.getCanonicalName());
			return;
		}
		
		final ConfirmRegistrationEmailDataModel dataModel = (ConfirmRegistrationEmailDataModel)_dataModel;
		final MsgSource msgSource = new MsgSource();
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(dataModel.getToEmail());
				message.setSubject(dataModel.getSubject());
				
				Map<String, Object> modelMap = new HashMap<String, Object>();
				modelMap.put("emailData", dataModel);
				modelMap.put("msgSource", msgSource);
				modelMap.put("locale", locale);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						getVelocityEngine(), "emailtemplates/ConfirmRegistration.vm", UTF8,
						modelMap);
				message.setText(text, IS_HTML);
			}
		};
		this.getMailSender().send(preparator);
		logger.info("Confirm Registration email sent to '" + dataModel.getToEmail() + "'");
	}

}
