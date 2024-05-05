package com.example.BorrowService.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Borrowing {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private boolean returned;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public boolean isReturned() {
		return returned;
	}
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	public Borrowing( Long userId, Long bookId, LocalDate borrowedDate, LocalDate returnDate,
			boolean returned) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.returned = returned;
	}
	public Borrowing() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Borrowing [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", borrowedDate=" + borrowedDate
				+ ", returnDate=" + returnDate + ", returned=" + returned + "]";
	}
    
	
    

}
