package com.spring.boot.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.spring.boot.email.dto.EmailRequest;
import com.spring.boot.email.dto.EmailResponse;

@Service
public class SMTPMailSender {

	Logger logger = LoggerFactory.getLogger(SMTPMailSender.class);

	@Autowired(required = true)
	private MailSender mailSender;

	public EmailResponse send(EmailRequest request) {
		EmailResponse response = null;
		SimpleMailMessage message = new SimpleMailMessage();

		try {
			message.setFrom("techbasanta757@gmail.com");
			message.setTo(request.getTo());
			message.setSubject(request.getSubject());
			message.setText(request.getComment());
			mailSender.send(message);
			response = new EmailResponse("SUCCESS", request.getTo().length);
		} catch (Exception e) {
			logger.info("Error while sending Email :" + e.getLocalizedMessage());
			response = new EmailResponse(e.getMessage(), request.getTo().length);
		}

		return response;
	}
}
