package com.roytuts.email.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.email.dto.EmailContent;
import com.roytuts.email.service.EmailService;

@RestController
public class EmailRestController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/email/send")
	public ResponseEntity<Void> sendEmail(@RequestBody EmailContent emailContent) {
		System.out.println("emailContent: " + emailContent);

		emailService.sendEmail(emailContent.getRecipient(), emailContent.getEmailFromAddress(),
				emailContent.getEmailReplyToAddress(), emailContent.getSubject(), emailContent.getContent());

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
