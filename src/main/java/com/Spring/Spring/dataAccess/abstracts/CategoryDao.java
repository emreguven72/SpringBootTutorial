package com.Spring.Spring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.Spring.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
}
