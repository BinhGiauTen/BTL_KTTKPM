package com.example.InventoryService.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.InventoryService.dto.InventoryResponse;
import com.example.InventoryService.models.Inventory;
import com.example.InventoryService.service.InventoryService;


import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

	 private final InventoryService inventoryService;

	 public InventoryController(InventoryService inventoryService) {
	     this.inventoryService = inventoryService;
	 }

    // http://localhost:9020/api/inventory/1,2

    // http://localhost:9020/api/inventory?bookId=1&bookId=2
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<Long> bookId) {
        return inventoryService.isInStock(bookId);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Inventory>> getAllInventory () {
        return new ResponseEntity<>(inventoryService.getAllInventoryes(), HttpStatus.OK);
    }
}