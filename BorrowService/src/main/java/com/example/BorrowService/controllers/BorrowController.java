package com.example.BorrowService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BorrowService.dto.BorrowRequest;
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
