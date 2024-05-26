package com.example.BookService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookService.models.Book;
import com.example.BookService.repositories.BookRepository;


@SpringBootApplication
public class BookServiceApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner loadData (BookRepository repository) {
//		return args -> {
//			Book book1 = new Book(1L, "Tieng Anh 1", "Nguyen Van Nam", "1 3949 293");
//			Book book2 = new Book(2L, "Tieng Anh 2", "Nguyen Van Nam", "9 3293 293");
//			Book book3 = new Book(3L, "TVTH", "Tran Van Bao", "1 324 3223");
//			Book book4 = new Book(4L, "CNM", "Pham Van Hai", "1 230483 294");
//			
//			repository.save(book1);
//			repository.save(book2);
//			repository.save(book3);
//			repository.save(book4);
//		};
//	}

	

}
