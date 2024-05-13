package com.example.InventoryService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InventoryService.models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByBookIdIn(List<Long> bookId);
}
