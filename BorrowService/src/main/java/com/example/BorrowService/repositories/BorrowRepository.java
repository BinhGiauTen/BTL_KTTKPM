package com.example.BorrowService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BorrowService.models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>{
	 List<Borrow> findByUserId(String userId);
}
