package com.Spring.Spring.business.abstracts;

import java.util.List;

import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;
import com.Spring.Spring.entities.concretes.Category;

public interface CategoryService {
	DataResult<List<Category>> getAll();
	Result add(Category category);
}
