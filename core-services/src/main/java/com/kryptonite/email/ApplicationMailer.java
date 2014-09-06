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
    @Autowired
    private JavaMailSender  mailSender;
    @Autowired
    private SimpleMailMessage registrationMessage;
    @Autowired
    private SimpleMailMessage passwordChangeMessage;
    @Autowired
    private SimpleMailMessage profileChangeMessage;
    @Autowired
    private SimpleMailMessage newPasswordMessage;
     
    public void sendRegistrationMessage(String to ) 
    {
    	 MimeMessage message = mailSender.createMimeMessage();
         try {
             MimeMessageHelper helper = new MimeMessageHelper(message, true);
             helper.setFrom(registrationMessage.getFrom());
             helper.setTo(to.trim());
             helper.setSubject(registrationMessage.getSubject());
             helper.setText(registrationMessage.getText(),true);
  
         } catch (MessagingException ex) {
             ex.printStackTrace();
         }
         mailSender.send(message);
    }
 
  
    public void sendPasswordChangeMessage(String to ) 
    {
    	 MimeMessage message = mailSender.createMimeMessage();
         try {
             MimeMessageHelper helper = new MimeMessageHelper(message, true);
             helper.setFrom(passwordChangeMessage.getFrom());
             helper.setTo(to.trim());
             helper.setSubject(passwordChangeMessage.getSubject());
             helper.setText(passwordChangeMessage.getText(),true);
  
         } catch (MessagingException ex) {
             ex.printStackTrace();
         }
         mailSender.send(message);
    }
 
    public void changeProfileMessage(String to) 
    {
    	 MimeMessage message = mailSender.createMimeMessage();
         try {
             MimeMessageHelper helper = new MimeMessageHelper(message, true);
             helper.setFrom(profileChangeMessage.getFrom());
             helper.setTo(to.trim());
             helper.setSubject(profileChangeMessage.getSubject());
             helper.setText(profileChangeMessage.getText(),true);
  
         } catch (MessagingException ex) {
             ex.printStackTrace();
         }
         mailSender.send(message);
    }
    
    public void sendNewPasswordMessage(String to) 
    {
    	 MimeMessage message = mailSender.createMimeMessage();
         try {
             MimeMessageHelper helper = new MimeMessageHelper(message, true);
             helper.setFrom(newPasswordMessage.getFrom());
             helper.setTo(to.trim());
             helper.setSubject(newPasswordMessage.getSubject());
             helper.setText(newPasswordMessage.getText(),true);
  
         } catch (MessagingException ex) {
             ex.printStackTrace();
         }
         mailSender.send(message);
    }
 
}