package com.vendertool.EmailApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vendertool.emailapp.VenderToolEmailService;
import com.vendertool.emailapp.datamodel.RegistrationEmailDataModel;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String args[]){
    	RegistrationEmailDataModel emailModel = new RegistrationEmailDataModel();
    	emailModel.setToEmail("Girish.Kodaganti@gmail.com");
    	emailModel.setToName("Kodaganti");
    	emailModel.setFromName("VTool Team");
    	emailModel.setSubject("Welcome to VTool!");
    	emailModel.setConfirmationCode("1234");
    	ApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	
    	VenderToolEmailService emailService = (VenderToolEmailService) context.getBean("registrationService");
    	emailService.sendEmail(emailModel);
    	System.out.println("Done");
    }
}
