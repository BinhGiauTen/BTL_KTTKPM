package com.example.InventoryService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.InventoryService.models.Inventory;
import com.example.InventoryService.repositories.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData (InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setId(1L);
			inventory.setBookId(1L);
			inventory.setQuantity(10);
			
			Inventory inventory2 = new Inventory();
			inventory2.setId(2L);
			inventory2.setBookId(2L);
			inventory2.setQuantity(10);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
			
		};
	}

}
