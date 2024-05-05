package com.example.BorrowService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BorrowService.models.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{
	 List<Borrowing> findByUserId(Long userId);
	 List<Borrowing> findByBookId(Long bookId);
}
