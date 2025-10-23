package com.roytuts.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.inventory.model.InventoryItem;
import com.roytuts.inventory.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

	@Autowired
	private InventoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		repository.save(new InventoryItem("P1001", 10));
		repository.save(new InventoryItem("P1002", 5));
	}
}
