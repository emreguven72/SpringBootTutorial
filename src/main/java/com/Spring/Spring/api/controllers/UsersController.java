package com.Spring.Spring.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.Spring.Spring.business.abstracts.UserService;
import com.Spring.Spring.core.entities.User;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value="/api/users")
@CrossOrigin
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	@GetMapping(value="/getByEmail")
	public DataResult<User> getByEmail(@RequestParam String email) {
		return this.userService.getByEmail(email);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<?> delete(@RequestParam String email) {
		return ResponseEntity.ok(this.userService.deleteByEmail(email));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String,String> validationErrors = new HashMap<String,String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
	}
	
	
}
