package com.example.BookService.Service;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

//    public Book saveBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public Book findBook(Long id) {
//        return bookRepository.findById(id).orElse(null);
//    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setAuthor(bookDetails.getAuthor());
            updatedBook.setIsbn(bookDetails.getIsbn());
            return bookRepository.save(updatedBook);
        } else {
            return null;
        }
    }

}