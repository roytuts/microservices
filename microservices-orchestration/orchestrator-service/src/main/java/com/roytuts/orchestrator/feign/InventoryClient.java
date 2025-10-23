package com.roytuts.orchestrator.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {

	@GetMapping("/inventory/check")
	boolean checkStock(@RequestParam String productId, @RequestParam int quantity);

	@PostMapping("/inventory/reserve")
	boolean reserveStock(@RequestParam String productId, @RequestParam int quantity);
}
