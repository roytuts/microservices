package com.roytuts.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/process")
	public boolean processPayment(@RequestParam String userId, @RequestParam double amount) {
		return paymentService.processPayment(userId, amount);
	}
}
