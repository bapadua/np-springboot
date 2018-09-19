package com.np.spring.api.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.spring.api.mail.MailSender;

@RestController
public class MailController {
	
	private MailSender mailsender;

	@Autowired
//	public MailController(@Qualifier("mockMailSender") MailSender mock) {
	public MailController(MailSender mock) {
		this.mailsender = mock;
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		mailsender.send("anjozero@gmail.com", "subject4u", "a test mail");
		return "Email sent";
	}
}
