package com.smoothstack.lms.admin.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.admin.dao.BookDao;
import com.smoothstack.lms.admin.entity.Book;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao; //return 404 if connection fails
	@Transactional
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookDao.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK); 
	}
	@Transactional
	public ResponseEntity<Book> createNewBook(Book newBook) {
		try {
			Book book =  bookDao.save(newBook);
			return new ResponseEntity<Book>(book, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Book> getBookById(int id) {
		try {
			Book book = bookDao.findById(id).get();
			return new ResponseEntity<Book>(book, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Book>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Book> updateBook(int id, Book newBook) {
		try {
			Book book = bookDao.findById(id).get();
			if(book == null) {
			    return new ResponseEntity<Book>(HttpStatus.NOT_FOUND); //404
			}
			bookDao.save(newBook);
			return new ResponseEntity<Book>(newBook, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Book>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Book> deleteBook(int id) {
		try {
			Book book = bookDao.findById(id).get();
			bookDao.delete(book);
			return new ResponseEntity<Book>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Book>( HttpStatus.NOT_FOUND);
		}
	}
}
