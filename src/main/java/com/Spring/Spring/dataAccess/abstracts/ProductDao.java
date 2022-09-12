package com.Spring.Spring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Spring.Spring.entities.concretes.Product;
import com.Spring.Spring.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product getByProductName(String productName);

	Product findById(int productId);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	List<Product> getByProductNameEndsWith(String productName);

	// Bu fonksiyonların içerisini doldurmamıza gerek yok Spring otomatik
	// oluşturuyor
	// Tek dikkat etmen gereken şey isimlendirme. Fonksiyonların içi isimlendirmeye
	// göre dolduruluyor.

	/*
	 * Eğer üstteki kısayolu kullanmadan kendin sql query yazmak istersen bunun da
	 * ama üsttekini kullan JPQL denilen nesne tabanlı query denilen kısa bir yolu
	 * var
	 */

	// JPQL yazmak(bunda isimlendirme önemli değil çünkü query'yi sen yazacaksın):

	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") 
	List<Product> getByProductNameAndCategoryIdUsingJPQL(String productName,int categoryId);
	  
	@Query("Select new com.Spring.Spring.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getAllProductsWithCategoryDetails();
	
	@Query("Select new com.Spring.Spring.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p where p.productName=:productName")
	ProductWithCategoryDto getProductWithCategoryDetails(String productName);

}
