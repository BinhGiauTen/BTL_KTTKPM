package com.example.BookService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;


@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner{
	
	@Autowired
    private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Tieng Anh 3", "Nguyen Van A", "SGK", "1234567890", LocalDate.of(2020, 1, 1));
        Book book2 = new Book("Nobody's Boy", "Hector Malot", "Novel", "0987654321", LocalDate.of(1878, 1, 1));
        Book book3 = new Book("Sherlock Holmes", "Arthur Conan Doyle", "Mystery", "1122334455", LocalDate.of(1887, 1, 1));
        Book book4 = new Book("Hercule Poirot", "Agatha Christie", "Mystery", "5566778899", LocalDate.of(1920, 1, 1));

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

}
