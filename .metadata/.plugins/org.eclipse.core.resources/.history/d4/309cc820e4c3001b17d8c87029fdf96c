package com.kenzan.employeetest.dao;

import java.util.ArrayList;
import java.util.List;

import com.kenzan.employeetest.entity.Employee;

public class EmployeeDAO {

	List<Employee> allEmployees = new ArrayList<Employee>();
	int employeeId = 0;

	public Employee save(Employee employee) {
		employeeId++;
		employee.setId(employeeId);
		allEmployees.add(employee);
		return employee;
	}

	public Object findById(int id) {
		allEmployees.get(id);
		return null;
	}

}
