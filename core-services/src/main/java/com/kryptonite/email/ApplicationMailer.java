package com.kryptonite.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
 
@Service("mailService")
public class ApplicationMailer 
{
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
     
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to,String notificationType ) 
    {
    	SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
    	mailMessage.setTo(to);
    	mailSender.send(mailMessage);
        
    	/*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);*/
    }
 
    
}