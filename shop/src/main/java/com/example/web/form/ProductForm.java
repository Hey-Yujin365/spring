package com.example.web.form;

import com.example.vo.Company;
import com.example.vo.Product;
import com.example.vo.ProductCategory;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {

	//@NotNull(message = "상품 카테고리는 필수 입력값입니다.")
	private Integer categoryNo;
	
	//@NotBlank(message = "상품명은 필수 입력값입니다.")
	private String name;
	
	//@NotNull(message = "제조회사는 필수 입력값입니다.")
	private Integer companyNo;
	
	//@NotNull(message = "가격은 필수 입력값입니다.")
	//@Min(value = 1, message = "가격은 0보다 큰 값만 허용됩니다.")
	private Integer price;
	
	//@NotNull(message = "입고수량은 필수 입력값입니다.")
	//@Min(value = 1, message = "입고수량은 0보다 큰 값만 허용됩니다.")
	private Integer amount;
	
	//@NotBlank(message = "상품설명은 필수 입력값입니다.")
	private String description;
	
	public Product toProduct() {
		Product product = new Product();
		product.setCategory(new ProductCategory(categoryNo));
		product.setCompany(new Company(companyNo));
		product.setName(name);
		product.setPrice(price);
		product.setStock(amount);
		product.setDescription(description);
		
		return product;
	}
}
