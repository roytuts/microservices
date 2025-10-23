package com.roytuts.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.inventory.model.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem, String> {
}
