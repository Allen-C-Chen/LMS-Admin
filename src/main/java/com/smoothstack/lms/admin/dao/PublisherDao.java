package com.smoothstack.lms.admin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.lms.admin.entity.Publisher;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Integer> {

}
