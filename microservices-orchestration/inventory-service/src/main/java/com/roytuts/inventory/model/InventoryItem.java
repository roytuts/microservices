package com.roytuts.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InventoryItem {

	@Id
	private String productId;
	private int quantity;

	public InventoryItem() {
	}

	public InventoryItem(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
