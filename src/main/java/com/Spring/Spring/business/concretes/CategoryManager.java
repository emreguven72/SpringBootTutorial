package com.Spring.Spring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Spring.business.abstracts.CategoryService;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;
import com.Spring.Spring.core.utilities.results.SuccessDataResult;
import com.Spring.Spring.core.utilities.results.SuccessResult;
import com.Spring.Spring.dataAccess.abstracts.CategoryDao;
import com.Spring.Spring.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	
	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(), "Tüm kategoriler listelendi");
	}

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult(category.getCategoryName() + " başarıyla eklendi");
	}

}
