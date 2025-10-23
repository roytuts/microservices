package com.roytuts.orchestrator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.FeignException;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignErrorDecoderConfig {

	@Bean
	public ErrorDecoder errorDecoder() {
		return (methodKey, response) -> {
            // Always throw base FeignException (covers all 4xx/5xx)
            return FeignException.errorStatus(methodKey, response);
        };
	}
}
