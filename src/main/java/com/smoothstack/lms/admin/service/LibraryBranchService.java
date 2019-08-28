package com.smoothstack.lms.admin.service;


import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.admin.dao.LibraryBranchDao;
import com.smoothstack.lms.admin.entity.LibraryBranch;
@Service
public class LibraryBranchService {
	@Autowired
	private LibraryBranchDao libraryBranchDao; //return 404 if connection fails
	@Transactional
	public ResponseEntity<List<LibraryBranch>> getAllLibraryBranchs() {
		List<LibraryBranch> libraryBranchs = libraryBranchDao.findAll();
		return new ResponseEntity<List<LibraryBranch>>(libraryBranchs, HttpStatus.OK); 
	}
	@Transactional
	public ResponseEntity<LibraryBranch> createNewLibraryBranch(LibraryBranch newLibraryBranch) {
		try {
			LibraryBranch libraryBranch =  libraryBranchDao.save(newLibraryBranch);
			return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<LibraryBranch>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<LibraryBranch> getLibraryBranchById(int id) {
		try {
			LibraryBranch libraryBranch = libraryBranchDao.findById(id).get();
			return new ResponseEntity<LibraryBranch>(libraryBranch, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<LibraryBranch>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<LibraryBranch> updateLibraryBranch(int id, LibraryBranch newLibraryBranch) {
		try {
			LibraryBranch libraryBranch = libraryBranchDao.findById(id).get();
			if(libraryBranch == null) {
			    return new ResponseEntity<LibraryBranch>(HttpStatus.NOT_FOUND); //404

			}
			newLibraryBranch.setBranchID(id);
			libraryBranchDao.save(newLibraryBranch);
			return new ResponseEntity<LibraryBranch>(newLibraryBranch, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<LibraryBranch>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<LibraryBranch> deleteLibraryBranch(int id) {
		try {
			LibraryBranch libraryBranch = libraryBranchDao.findById(id).get();
			libraryBranchDao.delete(libraryBranch);
			return new ResponseEntity<LibraryBranch>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<LibraryBranch>( HttpStatus.NOT_FOUND);
		}
	}
}
