package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.HrService;
import com.sample.vo.Department;
import com.sample.web.form.DeptCreateForm;

@Controller
@RequestMapping(path = "/dept")
public class DeptController {

	@Autowired
	HrService hrService;
	
	@PostMapping("/add")
	public String create(DeptCreateForm form) {
		hrService.addDept(form);
		
		return "redirect:list";
	}
	
	@GetMapping("/create")
	public String form() {
		
		return "dept/form";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Department> deptList = hrService.getAllDepts();

		model.addAttribute("deptList", deptList);
		
		return "dept/list";
	}
	
}
