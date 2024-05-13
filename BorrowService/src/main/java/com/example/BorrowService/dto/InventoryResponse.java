package com.example.BorrowService.dto;


public class InventoryResponse {
    private Long bookId;
    private boolean isInStock;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public InventoryResponse(Long bookId, boolean isInStock) {
		super();
		this.bookId = bookId;
		this.isInStock = isInStock;
	}
	public InventoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InventoryResponse [bookId=" + bookId + ", isInStock=" + isInStock + "]";
	}
    
    
}
