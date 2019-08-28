package com.smoothstack.lms.admin.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.admin.entity.BookLoan;
import com.smoothstack.lms.admin.entity.BookLoanID;


public interface BookLoanDao extends JpaRepository<BookLoan, BookLoanID>{

}
