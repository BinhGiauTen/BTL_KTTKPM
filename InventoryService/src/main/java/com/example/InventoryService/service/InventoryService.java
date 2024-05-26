package com.example.InventoryService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryService.dto.InventoryResponse;
import com.example.InventoryService.models.Inventory;
import com.example.InventoryService.repositories.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional()
    public List<InventoryResponse> isInStock(List<Long> bookIds) {
        try {
            // Lấy danh sách Inventory dựa trên các bookId truyền vào
            List<Inventory> inventories = inventoryRepository.findByBookIdIn(bookIds);

            // Chuyển đổi danh sách Inventory thành danh sách InventoryResponse
            return inventories.stream()
                    .map(inventory ->
                            new InventoryResponse(inventory.getBookId(), inventory.getQuantity() > 0)
                    )
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error processing request");
        }
    }
    
    public List<Inventory> getAllInventoryes() {
        return inventoryRepository.findAll();
    }
}

