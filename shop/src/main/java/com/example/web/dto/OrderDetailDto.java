package com.example.web.dto;

import java.util.List;

import com.example.vo.Order;
import com.example.vo.OrderItem;
import com.example.vo.OrderPayment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDto {

	private Order order;
	private List<OrderItem> orderItems;
	private OrderPayment payment;
	
}
