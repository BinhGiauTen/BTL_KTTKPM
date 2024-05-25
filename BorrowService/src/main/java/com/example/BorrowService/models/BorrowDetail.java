package com.example.BorrowService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BorrowDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BorrowDetail(Long id, Integer quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	public BorrowDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BorrowDetail [id=" + id + ", quantity=" + quantity + "]";
	}


}


//
//package com.example.BorrowService.models;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.redis.core.RedisHash;
//
//@RedisHash("BorrowDetail")
//@Getter
//@Setter
//@ToString
//public class BorrowDetail {
//	@Id
//	private Long id;
//	private Integer quantity;
//
//	public BorrowDetail(Long id) {
//		this.id = id;
//	}
//
//	public BorrowDetail() {
//	}
//
//	public BorrowDetail(Long id, Integer quantity) {
//		this.id = id;
//		this.quantity = quantity;
//	}
//	// getters, setters, constructors, and toString
//}