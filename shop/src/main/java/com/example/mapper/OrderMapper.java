package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Order;

@Mapper
public interface OrderMapper {

	void insertOrder(Order order);
	List<Order> getOrdersByUserNo(int userNo);
	Order getOrderByNo(int orderNo);
}
