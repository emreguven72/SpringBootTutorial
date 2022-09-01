package com.Spring.Spring.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.Spring.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User getByEmail(String email);
	
}
