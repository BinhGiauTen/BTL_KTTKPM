package com.example.InventoryService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.InventoryService.dto.InventoryResponse;
import com.example.InventoryService.repositories.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<Long> bookId) {
        return inventoryRepository.findByBookIdIn(bookId).stream()
                .map(inventory ->
                        new InventoryResponse(inventory.getBookId(), inventory.getQuantity() > 0)
                )
                .collect(Collectors.toList());
    }
}

