package com.sample.web.form;

import com.sample.vo.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmpModifyForm extends EmpCreateForm {

	private int no;

	public Employee toEmployee() {
		Employee emp = super.toEmployee();
		emp.setNo(no);
		
		return emp;
	}
}
