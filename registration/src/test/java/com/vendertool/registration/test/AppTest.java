package com.vendertool.registration.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.common.email.VenderToolEmailService;
import com.vendertool.registration.email.ConfirmRegistrationEmailDataModel;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String args[]){
    	ConfirmRegistrationEmailDataModel emailModel = new ConfirmRegistrationEmailDataModel();
    	emailModel.setToEmail("Girish.Kodaganti@gmail.com");
    	emailModel.setToName("Kodaganti");
    	emailModel.setFromName("VTool Team");
    	emailModel.setSubject("Welcome to VTool!");
    	//TODO : generate the real URL
 //   	emailModel.confirmationUrl("1234");
    	ApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	
    	VenderToolEmailService emailService = (VenderToolEmailService) context.getBean("registrationService");
    	emailService.sendEmail(emailModel, Locale.US);
    	System.out.println("Done");
    }
}
