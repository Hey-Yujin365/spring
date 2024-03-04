package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

	private int no;
	private String name;
	private String tel;
	private String email;
	private int salary;
	private Date hireDate;
	private Department dept;
	private Date createdDate;
	private Date updatedDate;
	
}
