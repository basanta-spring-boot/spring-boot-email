package com.spring.boot.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.email.SMTPMailSender;
import com.spring.boot.email.dto.EmailRequest;
import com.spring.boot.email.dto.EmailResponse;

@RestController
public class NotificationController {
	

	
	@Autowired(required = true)
	private SMTPMailSender sender;

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public EmailResponse sendEmail(@RequestBody EmailRequest request) {
		return sender.send(request);
	}
}
