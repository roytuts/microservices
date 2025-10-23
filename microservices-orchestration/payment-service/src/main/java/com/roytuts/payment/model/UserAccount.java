package com.roytuts.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAccount {

	@Id
	private String userId;
	private double balance;

	public UserAccount() {
	}

	public UserAccount(String userId, double balance) {
		this.userId = userId;
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
