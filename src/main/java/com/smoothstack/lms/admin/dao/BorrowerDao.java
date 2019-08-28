package com.smoothstack.lms.admin.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.admin.entity.Borrower;

public interface BorrowerDao extends JpaRepository<Borrower, Integer> {
	
}
