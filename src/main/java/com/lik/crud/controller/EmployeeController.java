package com.lik.crud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lik.crud.bean.Employee;
import com.lik.crud.bean.Msg;
import com.lik.crud.service.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
//	@ResponseBody
	public String emps(Model model) {
		
		PageHelper.startPage(0, 5);
		List<Employee> selectAllEmplyee2 = employeeService.selectAllEmplyee();
		PageInfo<Employee> pageInfo = new PageInfo<>(selectAllEmplyee2,5);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
		
	}
	
	@GetMapping("/list")
	@ResponseBody
	public Msg list() {
		PageHelper.startPage(0, 5);
		List<Employee> selectAllEmplyee2 = employeeService.selectAllEmplyee();
		PageInfo<Employee> pageInfo = new PageInfo<>(selectAllEmplyee2,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
}
