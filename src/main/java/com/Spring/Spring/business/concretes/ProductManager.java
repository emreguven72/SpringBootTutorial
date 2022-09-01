package com.Spring.Spring.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Spring.Spring.business.abstracts.ProductService;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.core.utilities.results.Result;
import com.Spring.Spring.core.utilities.results.SuccessDataResult;
import com.Spring.Spring.core.utilities.results.SuccessResult;
import com.Spring.Spring.dataAccess.abstracts.ProductDao;
import com.Spring.Spring.entities.concretes.Product;
import com.Spring.Spring.entities.dtos.ProductWithCategoryDto;

@Service //Bu sinif service gorevi gorecek
public class ProductManager implements ProductService{
	
	private ProductDao productDao;

	@Autowired //ProductDao sinifindan bir instans olusturuyor ve constructora otomatik bu nesneyi koyuyor.
	public ProductManager(ProductDao productDao) { 
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Tüm datalar listelendi");
	}	
	
	@Override
	public DataResult<List<Product>> getAll(int pageNumber, int dataPerPage) {
		Pageable pageable = PageRequest.of(pageNumber-1, dataPerPage);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Tüm datalar listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult(product.getProductName() + " ürünü eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi"); 
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameEndsWith(productName), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameAndCategoryIdUsingJPQL(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameAndCategoryIdUsingJPQL(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getAllProductsWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getAllProductsWithCategoryDetails(), "Data listelendi");
	}

	@Override
	public DataResult<ProductWithCategoryDto> getProductWithCategoryDetails(String productName) {
		return new SuccessDataResult<ProductWithCategoryDto>(this.productDao.getProductWithCategoryDetails(productName), "Data listelendi");
	}

}
