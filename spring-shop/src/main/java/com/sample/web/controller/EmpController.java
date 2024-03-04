package com.sample.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.sample.service.HrService;
import com.sample.vo.Department;
import com.sample.vo.Employee;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Controller
@RequestMapping(path = "/emp")
public class EmpController {

	@Autowired
	private HrService hrService;
	
	@GetMapping("/create")
	public String form(Model model) {
		List<Department> deptList = hrService.getAllDepts();
		
		model.addAttribute("deptList", deptList);
		
		return "/emp/form";
	}
	
	@PostMapping("/create")
	public String form(EmpCreateForm empCreateForm) {
		hrService.createEmp(empCreateForm);
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "rows", required = false, defaultValue = "10") int rows,
			@RequestParam(name = "sort", required = false, defaultValue = "date") String sort,
			Model model) {
		Criteria criteria = new Criteria();
		criteria.setPage(page);
		criteria.setRows(rows);
		criteria.setSort(sort);
		
		ListDto<Employee> dto = hrService.getAllEmps(criteria);
		model.addAttribute("empList", dto.getItems());
		model.addAttribute("criteria", criteria);
		
		return "emp/list";
	}
	
	@GetMapping(path = "/detail")
	public String detail(int no, Model model) {
		Employee employee = hrService.getEmpByNo(no);
		model.addAttribute("emp", employee);
		
		return "emp/detail";
	}
	
	@GetMapping("/modify")
	public String modifyform(int no, Model model) {
		List<Department> deptList = hrService.getAllDepts();
		Employee emp = hrService.getEmpByNo(no);
		model.addAttribute("deptList", deptList);
		model.addAttribute("emp", emp);
		
		return "emp/modifyform";
	}
	
	@PostMapping("/modify")
	public String modify(EmpModifyForm empModifyForm) {
		hrService.updateEmp(empModifyForm);
		
		return "redirect:detail?no="+ empModifyForm.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		hrService.deleteEmpByNo(no);
		
		return "redirect:list";
	}
}
