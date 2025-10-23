package com.roytuts.orchestrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.orchestrator.feign.PaymentClient;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PaymentInvoker {

	@Autowired
	private PaymentClient paymentClient;

	@Retry(name = "paymentRetry")
	public void invokePayment(String userId, double amount) {
		paymentClient.processPayment(userId, amount);
	}
}
