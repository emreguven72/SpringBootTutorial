package com.Spring.Spring.business.abstracts;

import com.Spring.Spring.core.entities.User;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;

public interface UserService {
	
	DataResult<User> getByEmail(String email);
	
	Result add(User user);
	
	Result deleteByEmail(String email);
	
}
