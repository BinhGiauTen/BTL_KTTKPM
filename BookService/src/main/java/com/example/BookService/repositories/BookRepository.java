package com.example.BookService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookService.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
