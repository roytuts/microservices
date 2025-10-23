package com.roytuts.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.orderservice.dto.OrderRequest;
import com.roytuts.orderservice.feign.OrchestratorClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrchestratorClient orchestratorClient;

	@PostMapping
	public String placeOrder(@RequestBody OrderRequest request) {
		return orchestratorClient.processOrder(request);
	}
}
