package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Employee;
import com.sample.web.dto.Criteria;

@Mapper
public interface EmployeeMapper {

	int getTotalRows(Criteria criteria);
	
	List<Employee> getAllEmps(Criteria criteria);

	void insertEmp(Employee emp);
	
	Employee getEmpByNo(int no);

	void updateEmp(Employee emp);

	void deleteEmpByNo(int no);

}
