package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Department;

@Mapper
public interface DepartmentMapper {

	List<Department> getAllDepts();
	
	void insertDept(Department dept);
}
