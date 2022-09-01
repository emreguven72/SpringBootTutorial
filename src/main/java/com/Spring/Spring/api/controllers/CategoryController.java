package com.Spring.Spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Spring.Spring.business.abstracts.CategoryService;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.entities.concretes.Category;

@RestController
@RequestMapping(value="/api/categories")
@CrossOrigin
public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Category>> getAll() {
		return this.categoryService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.add(category));
	}
	
}
