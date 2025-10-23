package com.roytuts.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.inventory.model.InventoryItem;
import com.roytuts.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository repository;

	public boolean checkStock(String productId, int quantity) {
		Optional<InventoryItem> item = repository.findById(productId);
		return item.map(i -> i.getQuantity() >= quantity).orElse(false);
	}

	public boolean reserveStock(String productId, int quantity) {
		Optional<InventoryItem> itemOpt = repository.findById(productId);
		if (itemOpt.isPresent()) {
			InventoryItem item = itemOpt.get();
			if (item.getQuantity() >= quantity) {
				item.setQuantity(item.getQuantity() - quantity);
				repository.save(item);
				return true;
			}
		}
		return false;
	}
}
