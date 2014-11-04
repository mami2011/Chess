package com.kryptonite.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

 
@Service("mailService")
public class ApplicationMailer 
{
    /*@Autowired
    private MailSender mailSender;*/
     
	@Autowired
    private JavaMailSender  mailSender;
	
    @Autowired
    private SimpleMailMessage registrationMessage;
    
    @Autowired
    private MailBodyCreator mailBodyCreator;
    
   
   /* public void sendRegistrationMessage(String to) 
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(registrationMessage);
        mailMessage.setTo(to);
        mailSender.send(mailMessage);
    }
    */
    
    public void sendRegistrationMessage(String to ) 
    {
    	 MimeMessage message = mailSender.createMimeMessage();
         try {
             MimeMessageHelper helper = new MimeMessageHelper(message, true);
             helper.setFrom(registrationMessage.getFrom());
             helper.setTo(to.trim());
             helper.setSubject(registrationMessage.getSubject());
             String mailBody = mailBodyCreator.buildCreateUserEmail(to);
             helper.setText(mailBody,true);
  
         } catch (MessagingException ex) {
             ex.printStackTrace();
         }
         mailSender.send(message);
    }
  
}