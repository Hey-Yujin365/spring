package com.example.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {

	private int no;
	private String name;
	private String description;
	private int stock;
	private String status;
	private int price;
	private String filename;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updatedDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	private Company company;
	private ProductCategory category;
}
