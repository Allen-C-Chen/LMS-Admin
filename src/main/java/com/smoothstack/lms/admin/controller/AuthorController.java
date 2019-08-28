package com.smoothstack.lms.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.admin.entity.Author;
import com.smoothstack.lms.admin.service.AuthorService;

@RestController
@RequestMapping(value = "/lms/admin")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	// Create a new Note
	@GetMapping(value = "/authors" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Author>> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@PostMapping(value = "/author",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
				return authorService.createNewAuthor(author);
	}
	@GetMapping(path = "/author/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Author> getAuthorByID(@PathVariable Integer id) {
		return authorService.getAuthorById(id);
	}
	
	@PutMapping(value = "/author/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Author> updateAuthor(
			@PathVariable Integer id,
			@Valid @RequestBody Author author) {
		return authorService.updateAuthor(id, author);
	}
	@DeleteMapping(value = "/author/{id}") //D
	public ResponseEntity<Author> deleteAuthor(@PathVariable Integer id){
		return authorService.deleteAuthor(id);
	}




	
}
