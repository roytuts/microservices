package com.roytuts.orchestrator.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.retry.RetryRegistry;

@Configuration
public class RetryLoggingConfig {

	@Bean
	public ApplicationRunner runner(RetryRegistry registry) {
		return _ -> {
			registry.retry("paymentRetry").getEventPublisher() //
					.onRetry(event -> System.out.println( //
							"Retry attempt #" + event.getNumberOfRetryAttempts() + //
									" due to: " + event.getLastThrowable().getMessage()));
		};
	}
	
}
