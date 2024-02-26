package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.ProductMapper;
import com.sample.vo.Product;
import com.sample.web.form.ProductCreateForm;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	/**
	 * ProductCreateForm 객체를 전달 받아서 신규 상품으로 등록한다.
	 * @param form신규 상품정보가 포함되어 있는 ProductCreateForm 객체
	 */
	public void createProduct(ProductCreateForm form) {
		// ProductCreateForm객체에 저장된 값으로 Product객체를 생성하고, 초기화한다.
		Product product = Product.builder()
				.name(form.getName())
				.description(form.getDescription())
				.price(form.getPrice())
				.stock(form.getStock())
				.build();
		
		productMapper.insertProduct(product);
	}
}
