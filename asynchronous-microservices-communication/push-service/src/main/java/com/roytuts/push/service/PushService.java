package com.roytuts.push.service;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.roytuts.push.dto.EmailDto;
import com.roytuts.push.dto.OfferDto;

@Service
public class PushService {

	@Autowired
	private RestTemplate restTemplate;

	@KafkaListener(topics = "${topic.name}", autoStartup = "true")
	public void sendNotification(ConsumerRecord<String, OfferDto> record) {

		OfferDto offerDto = record.value();

		System.out.println("offerDto: " + offerDto);

		try {
			// Send Email
			final EmailDto emailDto = new EmailDto();
			emailDto.setEmailFromAddress("roytuts@localhost.com");
			emailDto.setEmailReplyToAddress("no-reply@localhost.com");
			emailDto.setRecipient("roytuts@localhost.com");
			emailDto.setSubject("Save Cash On Transactions");
			emailDto.setContent(offerDto.getDescription());

			callEmailService(emailDto);
		} catch (Exception ex) {
			System.out.println("Ex: " + ex.getMessage());
		}

	}

	@Async
	public CompletableFuture<Void> callEmailService(EmailDto emailDto) {
		System.out.println("Calling Email Service...");

		final String msgServiceUrl = "http://localhost:8000/email/send";

		final Void response = restTemplate.postForObject(msgServiceUrl, emailDto, Void.class);

		return CompletableFuture.completedFuture(response);
	}
}
