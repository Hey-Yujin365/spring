package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sample.vo.Department;
import com.sample.vo.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmpCreateForm {

	private String name;
	private int deptNo;
	private String tel;
	private String email;
	private int salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	
	public Employee toEmployee() {
		Department dept = new Department();
		dept.setNo(deptNo);
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDept(dept);
		emp.setTel(tel);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		
		return emp;
	}
}
