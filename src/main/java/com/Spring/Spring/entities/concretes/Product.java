package com.Spring.Spring.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok framework. getter setter ve constructorlari otomatik verir.
@AllArgsConstructor //Constructor with all the variables
@NoArgsConstructor //Empty Constructor
@Entity //bu bir annotation. Bu sınıfın türünü belirtir. Entity adında bir interface oluşturup bu sınıfa implement etmek gibidir
@Table(name="products") //Veri tabaninda hangi tabloya karsilik geldigini gosterir.
public class Product {
	
	@Id //Tablonun primary keyi burdaki id diye belirtir.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	@Column(name="product_id") //bu degiskenin tablodaki isim karsiligi
	private int id;
	
	//@Column(name="category_id")
	//private int categoryId; database relationini yazdıktan sonra buraya gerek kalmıyor product.category.category_id ile cagirilabilir
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
}
