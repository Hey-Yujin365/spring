package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mapper.ProductCategoryMapper;
import com.example.mapper.ProductMapper;
import com.example.vo.Product;
import com.example.vo.ProductCategory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductMapper productMapper;
	private final ProductCategoryMapper productCategoryMapper;
	
	/**
	 * 모든 상품 카테고리 정보를 반환한다.
	 * @return 상품 카테고리 목록
	 */
	public List<ProductCategory> getAllProductCategories() {
		return productCategoryMapper.getProductCategories();
	}
	
	/**
	 * 지정된 카테고리에 속하는 상품 목록을 반환한다.
	 * @param categoryNo 카테고리 번호
	 * @return 상품 목록
	 */
	public List<Product> getProducts(int categoryNo) {
		return productMapper.getProductsByCategoryNo(categoryNo);
	}
	
	/**
	 * 지정된 상품번호에 해당하는 상품정보를 반환한다.
	 * @param productNo 상품번호
	 * @return 상품 정보
	 */
	public Product getProduct(int productNo) {
		return productMapper.getProductByNo(productNo);
	}
}
