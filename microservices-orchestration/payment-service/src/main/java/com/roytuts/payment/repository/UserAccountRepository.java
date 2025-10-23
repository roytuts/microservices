package com.roytuts.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.payment.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
