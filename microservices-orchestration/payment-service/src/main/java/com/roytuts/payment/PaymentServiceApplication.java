package com.roytuts.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.roytuts.payment.model.UserAccount;
import com.roytuts.payment.repository.UserAccountRepository;

@SpringBootApplication
public class PaymentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserAccountRepository repo) {
		return _ -> {
			repo.save(new UserAccount("U123", 1000.0));
			repo.save(new UserAccount("U456", 50.0));
		};
	}
}
