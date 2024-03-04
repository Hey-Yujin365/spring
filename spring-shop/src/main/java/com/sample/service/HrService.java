package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DepartmentMapper;
import com.sample.mapper.EmployeeMapper;
import com.sample.vo.Department;
import com.sample.vo.Employee;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.dto.Pagination;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Service
public class HrService {

	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Department> getAllDepts() {
		return departmentMapper.getAllDepts();
	}

	public void addDept(DeptCreateForm deptCreateForm) {
		
		Department dept = new Department();
		dept.setName(deptCreateForm.getName());
		dept.setTel(deptCreateForm.getTel());
		dept.setFax(deptCreateForm.getFax());
		
		departmentMapper.insertDept(dept);
	}

	public ListDto<Employee> getAllEmps(Criteria criteria) {
		int totalRows = employeeMapper.getTotalRows(criteria);
		
		Pagination pagination = new Pagination(criteria.getPage(), totalRows, criteria.getRows());
		criteria.setBegin(pagination.getBegin());
		criteria.setEnd(pagination.getEnd());
		
		List<Employee> empList = employeeMapper.getAllEmps(criteria);
		
		ListDto<Employee> dto = new ListDto<Employee>(empList, pagination);
		
		return dto;
	}

	public void createEmp(EmpCreateForm empCreateForm) {
		
		Employee emp = empCreateForm.toEmployee();
		employeeMapper.insertEmp(emp);
	}

	public Employee getEmpByNo(int no) {
		Employee employee = employeeMapper.getEmpByNo(no);
		
		return employee;
	}

	public void updateEmp(EmpModifyForm empModifyForm) {
		Employee emp = empModifyForm.toEmployee();
		employeeMapper.updateEmp(emp);
	}

	public void deleteEmpByNo(int no) {
		employeeMapper.deleteEmpByNo(no);
	}
}