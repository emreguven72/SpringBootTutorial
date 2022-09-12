package com.Spring.Spring.business.abstracts;

import com.Spring.Spring.core.entities.User;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;

import java.util.List;

public interface UserService {

	DataResult<List<User>> getAll();

	DataResult<User> getByEmail(String email);
	
	Result add(User user);
	
	Result deleteByEmail(String email);
	
}
