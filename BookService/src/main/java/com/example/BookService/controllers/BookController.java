//package com.example.BookService.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.BookService.models.Book;
//import com.example.BookService.repositories.BookRepository;
//
//@RestController
//@RequestMapping("/books")
//public class BookController {
//
//	@Autowired
//	private BookRepository bookRepository;
//
//	@PostMapping
//    public ResponseEntity<Book> addBook(@RequestBody Book book) {
//        Book savedBook = bookRepository.save(book);
//        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
//    }
//
//	@PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
//        java.util.Optional<Book> existingBook = bookRepository.findById(id);
//        if (existingBook.isPresent()) {
//            Book updatedBook = existingBook.get();
//            updatedBook.setTitle(book.getTitle());
//            updatedBook.setAuthor(book.getAuthor());
//            updatedBook.setGenre(book.getGenre());
//            updatedBook.setISBN(book.getISBN());
//            updatedBook.setPublishedDate(book.getPublishedDate());
//            updatedBook.setQuantity(book.getQuantity());
//            bookRepository.save(updatedBook);
//            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        bookRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//        java.util.Optional<Book> book = bookRepository.findById(id);
//        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks() {
//        List<Book> books = bookRepository.findAll();
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }
//}
package com.example.BookService.controllers;

import com.example.BookService.Service.BookService;
import com.example.BookService.models.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookService bookService;

//    @PostMapping
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        Book savedBook = bookService.saveBook(book);
//        return ResponseEntity.ok(savedBook);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//        Book book = bookService.findBook(id);
//        if (book != null) {
//            return ResponseEntity.ok(book);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.findBook(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setAuthor(bookDetails.getIsbn());
            Book updatedBook = bookService.saveBook(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        if (book != null) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
