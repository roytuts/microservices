package com.roytuts.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendEmail(String recipient, String emailFromAddress, String emailReplyToAddress, String subject,
			String content) throws MailException {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(emailFromAddress);
			messageHelper.setReplyTo(emailReplyToAddress);
			messageHelper.setTo(recipient);
			messageHelper.setSubject(subject);
			messageHelper.setText(content);
		};

		System.out.println("Sending Email ...");

		emailSender.send(messagePreparator);
		
		System.out.println("Email Sent!");
	}

}
