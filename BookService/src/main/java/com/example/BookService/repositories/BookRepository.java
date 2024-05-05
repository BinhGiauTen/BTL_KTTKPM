package com.example.BookService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookService.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
