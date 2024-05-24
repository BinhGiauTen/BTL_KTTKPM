package com.example.BorrowService.controllers;

import com.example.BorrowService.models.BorrowDetail;
import com.example.BorrowService.service.BorrowDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowDetails")
public class BorrowDetailController {

    @Autowired
    private BorrowDetailService borrowDetailService;

    @PostMapping
    public ResponseEntity<BorrowDetail> createBorrowDetail(@RequestBody BorrowDetail borrowDetail) {
        BorrowDetail savedDetail = borrowDetailService.saveBorrowDetail(borrowDetail);
        return ResponseEntity.ok(savedDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowDetail> getBorrowDetailById(@PathVariable Long id) {
        BorrowDetail detail = borrowDetailService.findBorrowDetail(id);
        if (detail != null) {
            return ResponseEntity.ok(detail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Thêm các endpoint khác tùy thuộc vào nhu cầu của ứng dụng
}
