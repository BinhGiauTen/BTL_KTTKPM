package com.example.BorrowService.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BorrowService.dto.BorrowRequest;
import com.example.BorrowService.service.BorrowService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
	
	@Autowired
	private BorrowService borrowService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public String borrowBooks(@RequestBody BorrowRequest borrowRequest) {
        return borrowService.borrowBooks(borrowRequest);
    }
    
    public String fallbackMethod(BorrowRequest borrowRequest, RuntimeException runtimeException) {
    	return "Oops! Something went wrong, please borrow after some time!";
    }


}
