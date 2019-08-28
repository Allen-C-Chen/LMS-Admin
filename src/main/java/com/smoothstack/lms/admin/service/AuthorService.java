package com.smoothstack.lms.admin.service;


import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.smoothstack.lms.admin.dao.AuthorDao;
import com.smoothstack.lms.admin.entity.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao authorDao; //return 404 if connection fails
	@Transactional
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authors = authorDao.findAll();
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK); 
	}
	@Transactional
	public ResponseEntity<Author> createNewAuthor(Author newAuthor) {
		try {
			Author author =  authorDao.save(newAuthor);
			return new ResponseEntity<Author>(author, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Author> getAuthorById(int id) {
		try {
			Author author = authorDao.findById(id).get();
			return new ResponseEntity<Author>(author, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Author>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Author> updateAuthor(int id, Author newAuthor) {
		try {
			Author author = authorDao.findById(id).get();
			if(author == null) {
			    return new ResponseEntity<Author>(HttpStatus.NOT_FOUND); //404
			}
			newAuthor.setAuthorId(id);
			authorDao.save(newAuthor);
			return new ResponseEntity<Author>(newAuthor, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Author>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Author> deleteAuthor(int id) {
		try {
			Author author = authorDao.findById(id).get();
			authorDao.delete(author);
			return new ResponseEntity<Author>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Author>( HttpStatus.NOT_FOUND);
		}
	}
}
