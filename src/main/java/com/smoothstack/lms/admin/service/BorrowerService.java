package com.smoothstack.lms.admin.service;


import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.admin.dao.BorrowerDao;
import com.smoothstack.lms.admin.entity.Borrower;
@Service
public class BorrowerService {
	@Autowired
	private BorrowerDao borrowerDao; //return 404 if connection fails
	@Transactional
	public ResponseEntity<List<Borrower>> getAllBorrowers() {
		List<Borrower> borrowers = borrowerDao.findAll();
		return new ResponseEntity<List<Borrower>>(borrowers, HttpStatus.OK); 
	}
	@Transactional
	public ResponseEntity<Borrower> createNewBorrower(Borrower newBorrower) {
		try {
			Borrower borrower =  borrowerDao.save(newBorrower);
			return new ResponseEntity<Borrower>(borrower, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Borrower>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Borrower> getBorrowerById(int id) {
		try {
			Borrower borrower = borrowerDao.findById(id).get();
			return new ResponseEntity<Borrower>(borrower, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Borrower>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Borrower> updateBorrower(int id, Borrower newBorrower) {
		try {
			Borrower borrower = borrowerDao.findById(id).get();
			if(borrower == null) {
			    return new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND); //404
			}
			borrowerDao.save(newBorrower);
			return new ResponseEntity<Borrower>(newBorrower, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Borrower>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Borrower> deleteBorrower(int id) {
		try {
			Borrower borrower = borrowerDao.findById(id).get();
			borrowerDao.delete(borrower);
			return new ResponseEntity<Borrower>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Borrower>( HttpStatus.NOT_FOUND);
		}
	}
}
