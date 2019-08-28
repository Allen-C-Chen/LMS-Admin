package com.smoothstack.lms.admin.service;


import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.admin.dao.PublisherDao;
import com.smoothstack.lms.admin.entity.Publisher;

@Service
public class PublisherService {
	@Autowired
	private PublisherDao publisherDao; //return 404 if connection fails
	@Transactional
	public ResponseEntity<List<Publisher>> getAllPublishers() {
		List<Publisher> publishers = publisherDao.findAll();
		return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK); 
	}
	@Transactional
	public ResponseEntity<Publisher> createNewPublisher(Publisher newPublisher) {
		try {
			Publisher publisher =  publisherDao.save(newPublisher);
			return new ResponseEntity<Publisher>(publisher, HttpStatus.CREATED); //201
		}
		catch(DataAccessException e){
		    return new ResponseEntity<Publisher>(HttpStatus.BAD_REQUEST); //404
		}
	}
	@Transactional
	public ResponseEntity<Publisher> getPublisherById(int id) {
		try {
			Publisher publisher = publisherDao.findById(id).get();
			return new ResponseEntity<Publisher>(publisher, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Publisher>( HttpStatus.NOT_FOUND);
		}
	}
	@Transactional
	public ResponseEntity<Publisher> updatePublisher(int id, Publisher newPublisher) {
		try {
			Publisher publisher = publisherDao.findById(id).get();
			if(publisher == null) {
			    return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND); //404

			}
			newPublisher.setPublisherId(id);
			publisherDao.save(newPublisher);
			return new ResponseEntity<Publisher>(newPublisher, HttpStatus.OK); 

		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Publisher>( HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Publisher> deletePublisher(int id) {
		try {
			Publisher publisher = publisherDao.findById(id).get();
			publisherDao.delete(publisher);
			return new ResponseEntity<Publisher>(HttpStatus.OK); 
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Publisher>( HttpStatus.NOT_FOUND);
		}
	}
}
