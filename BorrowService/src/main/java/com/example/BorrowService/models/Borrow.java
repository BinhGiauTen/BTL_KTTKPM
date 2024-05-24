//package com.example.BorrowService.models;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class Borrow {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String userId;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<BorrowDetail> books;
//    private LocalDate borrowedDate;
//    private LocalDate returnDate;
//    private boolean returned;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public List<BorrowDetail> getBooks() {
//		return books;
//	}
//	public void setBooks(List<BorrowDetail> books) {
//		this.books = books;
//	}
//	public LocalDate getBorrowedDate() {
//		return borrowedDate;
//	}
//	public void setBorrowedDate(LocalDate borrowedDate) {
//		this.borrowedDate = borrowedDate;
//	}
//	public LocalDate getReturnDate() {
//		return returnDate;
//	}
//	public void setReturnDate(LocalDate returnDate) {
//		this.returnDate = returnDate;
//	}
//	public boolean isReturned() {
//		return returned;
//	}
//	public void setReturned(boolean returned) {
//		this.returned = returned;
//	}
//	public Borrow(String userId, List<BorrowDetail> books, LocalDate borrowedDate, LocalDate returnDate,
//			boolean returned) {
//		super();
//		this.userId = userId;
//		this.books = books;
//		this.borrowedDate = borrowedDate;
//		this.returnDate = returnDate;
//		this.returned = returned;
//	}
//	public Borrow() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "Borrow [id=" + id + ", userId=" + userId + ", books=" + books + ", borrowedDate=" + borrowedDate
//				+ ", returnDate=" + returnDate + ", returned=" + returned + "]";
//	}
//
//
//}
package com.example.BorrowService.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;

@RedisHash("Borrow")
@Getter
@Setter
@ToString
public class Borrow {
	@Id
	private Long id;
	private String userId;
	private List<BorrowDetail> books;
	private LocalDate borrowedDate;
	private LocalDate returnDate;
	private boolean returned;

	// getters, setters, constructors, and toString

	public Borrow() {
	}

	public Borrow(Long id, String userId, List<BorrowDetail> books, LocalDate borrowedDate, LocalDate returnDate, boolean returned) {
		this.id = id;
		this.userId = userId;
		this.books = books;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.returned = returned;
	}
}


