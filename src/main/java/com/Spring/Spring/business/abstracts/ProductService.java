package com.Spring.Spring.business.abstracts;

import java.util.List;

import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;
import com.Spring.Spring.entities.concretes.Product;
import com.Spring.Spring.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNumber, int dataPerPage);

	DataResult<Product> getById(int productId);
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByProductNameEndsWith(String productName);
	
	DataResult<List<Product>> getByProductNameAndCategoryIdUsingJPQL(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getAllProductsWithCategoryDetails();
	
	DataResult<ProductWithCategoryDto> getProductWithCategoryDetails(String productName);
}
