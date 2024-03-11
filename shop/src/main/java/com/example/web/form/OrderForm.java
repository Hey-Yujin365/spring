package com.example.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderForm {

	// 1단계에서 입력되는 값
	private int productNo;
	private int amount;
	
	// 2단계에서 입력되는 값
	private String payType;
	private String cardNo;
	private String months;
	private int payAmount;
	
}
