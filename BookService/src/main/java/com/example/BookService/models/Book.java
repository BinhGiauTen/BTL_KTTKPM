package com.example.BookService.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private LocalDate publishedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Book(String title, String author, String genre, String iSBN, LocalDate publishedDate) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		ISBN = iSBN;
		this.publishedDate = publishedDate;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", ISBN=" + ISBN
				+ ", publishedDate=" + publishedDate + "]";
	}
	
	
    
    

}
