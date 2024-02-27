package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Product;

@Mapper
public interface ProductMapper {

	void insertProduct(Product product);
	
	List<Product> getAllProducts();

	Product getProductByNo(int no);
}
