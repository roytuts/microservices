package com.roytuts.orchestrator.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roytuts.orchestrator.config.FeignErrorDecoderConfig;

@FeignClient(name = "payment-service", url = "http://localhost:8083", configuration = FeignErrorDecoderConfig.class)
public interface PaymentClient {

	@PostMapping("/payment/process")
	boolean processPayment(@RequestParam String userId, @RequestParam double amount);
}
