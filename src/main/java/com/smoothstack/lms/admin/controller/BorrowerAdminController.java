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

import com.smoothstack.lms.admin.entity.Borrower;
import com.smoothstack.lms.admin.service.BorrowerService;

@RestController
@RequestMapping(value = "/lms/admin")
public class BorrowerAdminController {
	@Autowired
	private BorrowerService borrowerService;
	// Create a new Note
	@GetMapping(value = "/borrowers" ,
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<Borrower>> getAllBorrowers() {
		return borrowerService.getAllBorrowers();
	}
	
	@PostMapping(value = "/borrower",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Borrower> createBorrower(@Valid @RequestBody Borrower borrower) {
				return borrowerService.createNewBorrower(borrower);
	}
	@GetMapping(path = "/borrower/{id}",  
			produces = {"application/json", "application/xml"})  //R
	public ResponseEntity<Borrower> getBorrowerByID(@PathVariable Integer id) {
		return borrowerService.getBorrowerById(id);
	}
	
	@PutMapping(value = "/borrower/{id}",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<Borrower> updateBorrower(
			@PathVariable Integer id,
			@Valid @RequestBody Borrower borrower) {
		return borrowerService.updateBorrower(id, borrower);
	}
	@DeleteMapping(value = "/borrower/{id}") //D
	public ResponseEntity<Borrower> deleteBorrower(@PathVariable Integer id){
		return borrowerService.deleteBorrower(id);
	}




	
}
