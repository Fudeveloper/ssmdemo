package com.lik.crud.service;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lik.crud.bean.Employee;
import com.lik.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> selectAllEmplyee() {
		List<Employee> selectByExampleWithDept = employeeMapper.selectByExampleWithDept(null);
//		for (Employee employee : selectByExampleWithDept) {
//			System.out.println(employee);
//		}
		return selectByExampleWithDept;
	}
}
