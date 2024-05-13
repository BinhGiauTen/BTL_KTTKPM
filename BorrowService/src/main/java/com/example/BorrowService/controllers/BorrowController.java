package com.example.BorrowService.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BorrowService.dto.BorrowRequest;
import com.example.BorrowService.models.Borrow;
import com.example.BorrowService.repositories.BorrowRepository;
import com.example.BorrowService.service.BorrowService;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
	
	@Autowired
	private BorrowService borrowService;
	

    @PostMapping
    public ResponseEntity<?> borrowBooks(@RequestBody BorrowRequest borrowRequest) {
        borrowService.borrowBooks(borrowRequest);
        return ResponseEntity.ok("Books borrowed successfully.");
    }


}
