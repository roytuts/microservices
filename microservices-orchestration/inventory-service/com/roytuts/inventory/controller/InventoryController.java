package com.roytuts.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/check")
	public boolean checkStock(@RequestParam String productId, @RequestParam int quantity) {
		return inventoryService.checkStock(productId, quantity);
	}

	@PostMapping("/reserve")
	public boolean reserveStock(@RequestParam String productId, @RequestParam int quantity) {
		return inventoryService.reserveStock(productId, quantity);
	}
}
