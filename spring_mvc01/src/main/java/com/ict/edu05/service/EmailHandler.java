package com.ict.edu05.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.mysql.cj.protocol.MessageSender;

public class EmailHandler {
	private JavaMailSender javaMailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public EmailHandler(JavaMailSender javaMailSender) throws Exception {
		this.javaMailSender = javaMailSender;
		
		message = this.javaMailSender.createMimeMessage();
		
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		
		//단순한 텍스트 메시지만 사용
		//messageHelper = new M
		
	}
	
	//제목
	public void setSubject(String subject) throws  Exception{
		messageHelper.setSubject(subject);
	}
	//내용
	public void setText(String text) throws  Exception{
		// true => 태그 사용 가능
		messageHelper.setText(text, true);
	}
	
	//보낸사람의 이메일과 
	public void setForm(String email, String name) throws  Exception{
		messageHelper.setFrom(email, name);
	}
	
	//받는 이메일
	public void setTo(String email) throws Exception{
		messageHelper.setTo(email);
	}
	
	public void send() {
		
	}
	
}
