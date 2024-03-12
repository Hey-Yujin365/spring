package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.ShopException;
import com.example.mapper.OrderItemMapper;
import com.example.mapper.OrderMapper;
import com.example.mapper.OrderPaymentMapper;
import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import com.example.vo.Order;
import com.example.vo.OrderItem;
import com.example.vo.OrderPayment;
import com.example.vo.Product;
import com.example.vo.User;
import com.example.web.dto.OrderDetailDto;
import com.example.web.form.OrderForm;

import lombok.RequiredArgsConstructor;

/*
 * @Transactional
 * 		- 선언적 트랜잭션 처리를 지원하는 어노테이션이다.
 * 		- @Transactional 어노테이션은 인터페이스, 클래스, 메소드에 붙일 수 있다.
 * 		  + 인터페이스에 지정하면 해당 인터페이스를 구현한 구현객체의 각 메소드가 실행될 때 마다 트랜잭션처리가 지원된다.
 * 		  + 클래스에 지정하면 해당 클래스로 생성한 객체의 각 메소드가 실행될 때마다 트랜잭션처리가 지원된다.
 * 		  + 메소드에 지정하면 해당 메소드가 실행될 대마다 트랜잭션처리가 지원된다.
 * 		- 선언적 트랜잭션 처리가 지원되면 해당 메소드가 실행되기 전에 새로운 트랜잭션이 시작된다.
 * 		  + 트랜잭션이 시작된다는 말은 데이터베이스에서 지금부터 실행하는 모든 SQL 구문을 하나의 논리적인 그룹으로 묶을 준비가 되었다는 것이다.
 * 		  + 메소드내에서 데이터베이스 액세스 작업을 할 때마다 해당 SQL 작업을 트랜잭션에 추가한다.
 * 		- 선언적 트랜잭션 처리가 지원되면 해당 메소드가 종료될 때 트랜잭션을 종료한다.
 * 		  + 해당 메소드를 실행하면서 RuntimeException의 하위 예외가 발생하면 해당 트랜잭션에 추가된 모든 작업에 대해서 rollback을 실행한다.
 * 		  + 해당 메소드를 실행하면서 예외가 발생하지 않으면 해당 트랜잭션에 추가된 모든 작업에 대해서 commit을 실행한다.  
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final ProductMapper productMapper;
	private final OrderMapper orderMapper;
	private final OrderItemMapper orderItemMapper;
	private final OrderPaymentMapper orderPaymentMapper;
	private final UserMapper userMapper;
	
	// 컨트롤러 completed에서 orderNo를 사용할 수 있게 반환값으로 Order를 넘긴다.
	public Order saveOrder(OrderForm orderForm, String userId) {
		// 주문 정보를 저장한다.
		User user = userMapper.getUserById(userId);

		Order order = new Order();
		order.setUser(user);
		order.setTotalPrice(orderForm.getTotalPrice());
		
		orderMapper.insertOrder(order);
		
		// 주문 상품정보를 저장한다.
		Product product = productMapper.getProductByNo(orderForm.getProductNo());
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderNo(order.getNo());
		orderItem.setAmount(orderForm.getAmount());
		orderItem.setPrice(product.getPrice());
		orderItem.setProduct(product);
		
		orderItemMapper.insertOrderItem(orderItem);
		
		// 결제 정보를 저장한다.
		OrderPayment orderPayment = new OrderPayment();
		orderPayment.setOrder(order);
		orderPayment.setType(orderForm.getPayType());
		orderPayment.setAccNo(orderForm.getCardno());
		orderPayment.setMonths(orderForm.getMonths());
		orderPayment.setAmount(orderForm.getTotalPrice());
		
		orderPaymentMapper.insertOrderPayment(orderPayment);
		
		return order;
	}
	
	public OrderDetailDto getOrderDetail(int orderNo, String userId) {
		OrderDetailDto dto = new OrderDetailDto();
		
		User user = userMapper.getUserById(userId);
		Order order = orderMapper.getOrderByNo(orderNo);
		if (user.getNo() != order.getUser().getNo()) {
			throw new ShopException("다른 사용자의 주문정보는 조회할 수 없습니다.");
		}
		
		List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderNo(orderNo);
		OrderPayment payment = orderPaymentMapper.getOrderPaymentByOrderNo(orderNo);
		
		dto.setOrder(order);
		dto.setOrderItems(orderItems);
		dto.setPayment(payment);
		
		return dto;
	}
	
	
}
