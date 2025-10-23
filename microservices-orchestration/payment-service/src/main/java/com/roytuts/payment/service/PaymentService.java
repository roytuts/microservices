package com.roytuts.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.payment.model.UserAccount;
import com.roytuts.payment.repository.UserAccountRepository;

@Service
public class PaymentService {

	@Autowired
	private UserAccountRepository repository;

	public boolean processPayment(String userId, double amount) {
		Optional<UserAccount> accountOpt = repository.findById(userId);
		
		if (accountOpt.isPresent()) {
			UserAccount account = accountOpt.get();
			if (account.getBalance() >= amount) {
				account.setBalance(account.getBalance() - amount);
				repository.save(account);
				return true;
			}
		}
		
		return false;
		
		//throw new RuntimeException("Simulated payment failure");
	}
}
