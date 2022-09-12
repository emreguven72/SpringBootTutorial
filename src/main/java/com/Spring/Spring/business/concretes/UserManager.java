package com.Spring.Spring.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Spring.business.abstracts.UserService;
import com.Spring.Spring.core.dataAccess.UserDao;
import com.Spring.Spring.core.entities.User;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;
import com.Spring.Spring.core.utilities.results.SuccessDataResult;
import com.Spring.Spring.core.utilities.results.SuccessResult;

import java.util.List;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), "Data listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(user.getEmail() + " kullanıcısı eklendi");
	}

	@Override
	public Result deleteByEmail(String email) {
		this.userDao.delete(this.userDao.getByEmail(email));
		return new SuccessResult(email + " kullanıcısı silindi");
	}

}
