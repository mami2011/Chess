package com.vendertool.common.email;

import java.util.Locale;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;

public abstract class VenderToolEmailService {

	public static final boolean IS_HTML = true;
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public abstract void sendEmail(EmailDataModel dataModel, Locale locale);
}