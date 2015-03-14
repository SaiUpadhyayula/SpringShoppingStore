package com.spring.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	private final String FROM_ID = "info.demoproduct@gmail.com";
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendRegistrationEmail(String emailId,String userName,String text){
		SimpleMailMessage simpleMailMessage  = new SimpleMailMessage();
		simpleMailMessage.setFrom(FROM_ID);
		simpleMailMessage.setTo(emailId);
		simpleMailMessage.setSubject("Activation Mail for "+userName);
		simpleMailMessage.setText(text);
		System.out.println(javaMailSender.getUsername());
		System.out.println(javaMailSender.getPassword());
		System.out.println(javaMailSender.getHost());
		javaMailSender.send(simpleMailMessage);
	}
}
