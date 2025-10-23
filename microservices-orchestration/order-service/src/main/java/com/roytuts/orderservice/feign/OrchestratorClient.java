package com.roytuts.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.roytuts.orderservice.dto.OrderRequest;

@FeignClient(name = "orchestrator-service", url = "http://localhost:8084")
public interface OrchestratorClient {

	@PostMapping("/orchestrate")
	String processOrder(OrderRequest request);
	
}
