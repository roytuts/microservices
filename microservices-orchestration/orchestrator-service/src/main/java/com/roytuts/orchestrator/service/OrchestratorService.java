package com.roytuts.orchestrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.orchestrator.dto.OrderRequest;
import com.roytuts.orchestrator.feign.InventoryClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrchestratorService {

	@Autowired
	private InventoryClient inventoryClient;

	@Autowired
    private PaymentInvoker paymentInvoker;

	@Retry(name = "paymentRetry")
	@CircuitBreaker(name = "paymentCircuitBreaker", fallbackMethod = "paymentFallback")
	public String processOrder(OrderRequest request) {
		boolean inStock = inventoryClient.checkStock(request.getProductId(), request.getQuantity());
		if (!inStock)
			return "Order Failed: Product out of stock.";

		boolean reserved = inventoryClient.reserveStock(request.getProductId(), request.getQuantity());
		if (!reserved)
			return "Order Failed: Unable to reserve stock.";

		paymentInvoker.invokePayment(request.getUserId(), request.getQuantity() * 100);

		return "Order Placed Successfully!";
	}

	// fallback must match the signature of the circuit breaker method
	public String paymentFallback(OrderRequest request, Throwable t) {
		return "Order Failed: Payment service unavailable. Please try again later.";
	}
}
