package com.kenzan.employeetest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.kenzan.employeetest.dao.EmployeeDAO;
import com.kenzan.employeetest.entity.Employee;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeDAO dao;

	public Employee createEmployee(Employee employee) {
		return dao.save(employee);

	}

	public Employee getEmployeeById(int id) {

		return null;
	}

	public Employee getEmployees() {

		return null;
	}

	public void deleteEmployee(int id) {

	}

	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}