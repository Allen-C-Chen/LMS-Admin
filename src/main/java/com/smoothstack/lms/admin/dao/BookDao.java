package com.smoothstack.lms.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.admin.entity.Book;



public interface BookDao extends JpaRepository<Book, Integer> {
	
}
