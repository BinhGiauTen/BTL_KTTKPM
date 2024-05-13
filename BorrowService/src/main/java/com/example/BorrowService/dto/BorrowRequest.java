package com.example.BorrowService.dto;


import java.util.List;

public class BorrowRequest {
    private String userId;
    private List<BookRequest> books;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<BookRequest> getBooks() {
        return books;
    }

    public void setBooks(List<BookRequest> books) {
        this.books = books;
    }
}

