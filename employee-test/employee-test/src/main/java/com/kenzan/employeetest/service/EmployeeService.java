package com.kenzan.employeetest.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public List<Employee> getEmployees() {
		return dao.findAll();
	}

	public Employee getEmployeeById(int id) throws Exception {
		try {
			return dao.findById(id);
		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered when trying to gather the Employee info with id: " + id, x);
			throw new Exception("Could not successfully locate this Employee, please try again.");
		}

	}

	public void deleteEmployee(int id) throws Exception {
		try {
			dao.deleteById(id);
		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered when trying to delete Employee with id: " + id, x);
			throw new Exception("Could not successfully delete this Employee, please try again.");
		}

	}

	public Employee updateEmployee(int id, Employee employee) throws Exception {
		try {
			return dao.update(employee, id);

		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered in Employee Service when trying to update Employee with id: " + id, x);
			throw new Exception("Could not successfully update this Employee, please try again.");
		}

	}
}