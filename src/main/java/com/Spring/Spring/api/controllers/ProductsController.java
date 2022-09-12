package com.Spring.Spring.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Spring.Spring.business.abstracts.ProductService;
import com.Spring.Spring.core.utilities.results.DataResult;
import com.Spring.Spring.entities.concretes.Product;
import com.Spring.Spring.entities.dtos.ProductWithCategoryDto;

@RestController //Sanirim RESTFUL API controlleri oldugunu belirtiyor.
@RequestMapping(value="/api/products") //bir apide bircok controller vardir.Bu controllera hangi isimle erisilecegini belirtir.
								 //Ornegin sitemizin adi emre olsun emre/api/productsa gidilirse bu controllera istek atilir.
@CrossOrigin //Bu apiye disardan erisilebilme izni verir
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getAll") //bu bir get requestidir yani veri isteyecegim. emre/api/products/getall bu fonksiyonu cagirir.
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	
	@GetMapping("/getAllByPage") //bu bir get requestidir yani veri isteyecegim. emre/api/products/getall bu fonksiyonu cagirir.
	public DataResult<List<Product>> getAll(@RequestParam int pageNumber, @RequestParam int dataPerPage) {
		return this.productService.getAll(pageNumber, dataPerPage);
	}

	@GetMapping("/getById")
	public DataResult<Product> getById(@RequestParam int productId) {
		return this.productService.getById(productId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.add(product));
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories) {
		return this.productService.getByCategoryIdIn(categories);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByProductNameEndsWith")
	public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam String productName) {
		return this.productService.getByProductNameEndsWith(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryIdUsingJPQL")
	public DataResult<List<Product>> getByProductNameAndCategoryIdUsingJPQL(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategoryIdUsingJPQL(productName, categoryId);
	}
	
	@GetMapping("/getAllProductsWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getAllProductsWithCategoryDetails();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<ProductWithCategoryDto> getProductWithCategoryDetails(String productName) {
		return this.productService.getProductWithCategoryDetails(productName);
	}
	 
	
}
