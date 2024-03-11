package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.service.ProductService;
import com.example.vo.Product;
import com.example.web.form.OrderForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@SessionAttributes({"orderForm"})
public class OrderController {

	private final ProductService productService;
	
	/*
	 * 요청방식
	 * 	GET
	 * 요청 URL
	 * 	localhost/order/step1?no=122
	 * 요청 파라미터
	 * 	no=122
	 * 요청 내용
	 * 	지정된 상품번호에 대한 주문정보 입력폼을 요청한다.
	 * 처리 내용
	 * 	요청파라미터로 전달받은 상품정보에 대한 상세정보를 조회해서 모델에 저장하고, 주문정보 입력화면으로 내부이동한다.
	 */
	@GetMapping("/step1")
	public String step1(@RequestParam("no") int productNo, Model model) {
		Product product = productService.getProduct(productNo);
		model.addAttribute("product", product);
		model.addAttribute("orderForm", new OrderForm());
		
		return "order/orderform";
	}
	
	@PostMapping("/step2")
	public String step2(OrderForm orderForm) {
		
		return "order/payform";
	}
	
	@PostMapping("/step3")
	public String step3(OrderForm orderForm) {
		
		return "order/completed";
	}
	
}
