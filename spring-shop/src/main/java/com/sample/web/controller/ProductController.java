package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.ProductService;
import com.sample.web.form.ProductCreateForm;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@GetMapping(path = "/list")
	public String list() {
		
		return "product/list";	// "/WEB-INF/views/product/list.jsp"로 내부이동
	}
	
	@GetMapping(path = "/create")
	public String form() {
		return "product/form";	// "/WEB-INF/views/product/form.jsp"로 내부이동
	}
	
	@PostMapping("/create")
	public String create(ProductCreateForm productCreateForm) {
		productService.createProduct(productCreateForm);
		
		return "redirect:list";
	}
}
