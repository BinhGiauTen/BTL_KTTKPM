package com.example.BorrowService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BorrowService.models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>{
	 List<Borrow> findByUserId(String userId);
}




//
//package com.example.BorrowService.repositories;
//
//import com.example.BorrowService.models.Borrow;
//import org.springframework.data.repository.CrudRepository;
//
//public interface BorrowRepository extends CrudRepository<Borrow, Long> {
//}