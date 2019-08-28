package com.smoothstack.lms.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.admin.entity.Author;


@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
	
}
