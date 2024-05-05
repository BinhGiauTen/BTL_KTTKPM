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

import com.example.BorrowService.models.Borrowing;
import com.example.BorrowService.repositories.BorrowingRepository;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
	@Autowired
    private BorrowingRepository borrowingRepository;

    @PostMapping
    public ResponseEntity<Borrowing> borrowBook(@RequestBody Borrowing borrowing) {
        borrowing.setBorrowedDate(LocalDate.now());
        borrowing.setReturned(false);
        Borrowing savedBorrowing = borrowingRepository.save(borrowing);
        return new ResponseEntity<>(savedBorrowing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Borrowing> returnBook(@PathVariable Long id) {
        Borrowing borrowing = borrowingRepository.findById(id).orElse(null);
        if (borrowing != null) {
            borrowing.setReturned(true);
            borrowing.setReturnDate(LocalDate.now());
            Borrowing returnedBorrowing = borrowingRepository.save(borrowing);
            return new ResponseEntity<>(returnedBorrowing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Borrowing>> getBorrowingsByUser(@PathVariable Long userId) {
        List<Borrowing> borrowings = borrowingRepository.findByUserId(userId);
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Borrowing>> getBorrowingsByBook(@PathVariable Long bookId) {
        List<Borrowing> borrowings = borrowingRepository.findByBookId(bookId);
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }
}
