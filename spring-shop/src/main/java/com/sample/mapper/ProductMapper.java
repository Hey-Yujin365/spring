package com.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Product;

@Mapper
public interface ProductMapper {

	void insertProduct(Product product);
}
