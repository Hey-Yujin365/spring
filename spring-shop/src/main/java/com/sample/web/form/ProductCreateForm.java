package com.sample.web.form;

import org.springframework.web.multipart.MultipartFile;

import com.sample.vo.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCreateForm {

	private int companyNo;
	private String name;
	private int price;
	private int stock;
	private MultipartFile photofile;
	private String description;
	
}
