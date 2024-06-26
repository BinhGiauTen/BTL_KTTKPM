package com.example.BorrowService.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
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
@EnableRetry
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	@Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(5000); // Retry after 5 seconds
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(5); // Maximum retry attempts
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public String borrowBooks(@RequestBody BorrowRequest borrowRequest) {
    	RetryTemplate retryTemplate = retryTemplate();
        return retryTemplate.execute(context -> borrowService.borrowBooks(borrowRequest)) ;
    }

    public String fallbackMethod(BorrowRequest borrowRequest, RuntimeException runtimeException) {
    	return "Oops! Something went wrong, please borrow after some time!";
    }


}






//package com.example.BorrowService.controllers;
//
//import com.example.BorrowService.models.Borrow;
//import com.example.BorrowService.service.BorrowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/borrows")
//public class BorrowController {
//
//    @Autowired
//    private BorrowService borrowService;
//
//    @PostMapping
//    public ResponseEntity<Borrow> createBorrow(@RequestBody Borrow borrow) {
//        Borrow savedBorrow = borrowService.saveBorrow(borrow);
//        return ResponseEntity.ok(savedBorrow);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
//        Borrow borrow = borrowService.findBorrow(id);
//        if (borrow != null) {
//            return ResponseEntity.ok(borrow);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Thêm các endpoint khác tùy thuộc vào nhu cầu của ứng dụng
//}
