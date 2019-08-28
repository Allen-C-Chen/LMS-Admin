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

import com.smoothstack.lms.admin.entity.BookLoan;
import com.smoothstack.lms.admin.service.BookLoanService;

@RestController
@RequestMapping("/lms/admin")
public class BookLoanAdminController {
	@Autowired
	private BookLoanService bookLoanService;

	
	@GetMapping(value = "/loaned-books",
			produces = {"application/json", "application/xml"}) 
	public ResponseEntity<List<BookLoan>> getAllBookLoans() {
		return bookLoanService.getAllBookLoans();
	}
	//borrower/{cardNo}/book
	@GetMapping(
			value = "/loaned-book/librarybranch/{libBranchId}/book/{bookId}/borrower/{cardNo}",
			produces = {"application/json", "application/xml"})//R
	public ResponseEntity<BookLoan> getBookLoanByID(@PathVariable Integer libBranchId,
			@PathVariable Integer bookId,
			@PathVariable Integer cardNo) {
	    return bookLoanService.getBookLoanById(libBranchId, bookId, cardNo);
	}
	@PutMapping(
			value = "/loaned-book/librarybranch/{libBranchId}/book/{bookId}/borrower/{cardNo}/override/checkoutdate",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})  //U
	public ResponseEntity<BookLoan> overrideCheckOutDate(
			@PathVariable Integer libBranchId,
			@PathVariable Integer bookId,
			@PathVariable Integer cardNo,
			@RequestBody BookLoan bookLoanData) {
			return bookLoanService.overrideCheckOutDate(
					libBranchId, bookId, cardNo, bookLoanData);
		}
	// Create a new Note
	@PostMapping(value = "/loaned-book",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"})//C
	public ResponseEntity<BookLoan> createBookLoan(@Valid @RequestBody BookLoan bookLoan) {
		return bookLoanService.createNewBookLoan(bookLoan);
	}
	@DeleteMapping(value = "/loaned-book/librarybranch/{libBranchId}/book/{bookId}/borrower/{cardNo}")
	public ResponseEntity<BookLoan> deleteBookLoan(@PathVariable Integer libBranchId,
			@PathVariable Integer bookId,
			@PathVariable Integer cardNo) {
		return bookLoanService.deleteBookLoan(libBranchId, bookId, cardNo);
	}

}
