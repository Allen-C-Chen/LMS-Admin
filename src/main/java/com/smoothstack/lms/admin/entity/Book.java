package com.smoothstack.lms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
    @Column(name = "title")
	private String title;
    @ManyToOne
    @JoinColumn(name = "authId")
	private Author author;
    @ManyToOne
    @JoinColumn(name = "pubId")
	private Publisher publisher;
    
    
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(Integer bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(String title, Author author, Publisher publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public Book(Integer bookId, String title, Author author, Publisher publisher) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}


    
}

