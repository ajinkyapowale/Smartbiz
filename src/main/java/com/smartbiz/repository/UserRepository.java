package com.smartbiz.repository;

import org.springframework.data.repository.Repository;

import com.smartbiz.model.User;

public interface UserRepository extends Repository<User, Long>{
	
	User findByEmailId(String emailId);
	
}
