package com.kenzan.employeetest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.kenzan.employeetest.entity.Employee;
import com.kenzan.employeetest.util.Status;

@Component
public class EmployeeDAO {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);

	 List<Employee> allEmployees = new ArrayList<Employee>();
	int employeeId = 0;

	public Employee save(Employee employee) {
		employeeId++;
		employee.setId(employeeId);
		employee.setStatus(Status.ACTIVE);
		allEmployees.add(employee);
		return employee;
	}

	public  Employee findById(int id) {
		Employee activeEmployee = allEmployees
				.stream().filter(e -> e.getId() == id && e.getStatus() == Status.ACTIVE)
				.findFirst().get();

		return activeEmployee;
	}

	public List<Employee> findAll() {
		List<Employee> activeEmployees = allEmployees
				.stream().filter(e -> e.getStatus() == Status.ACTIVE)
				.collect(Collectors.toList());

		return activeEmployees;
	}

	public void deleteById(int id) {
		allEmployees.forEach(e -> {
			if (e.getId() == id) {
				e.setStatus(Status.INACTIVE);
			}
		});
	}

	
	public Employee update(Employee employee, int id) throws Exception {
		Employee olderEmployee = findById(id);
		allEmployees.remove(olderEmployee);
		try {
			if (employee.getFirstName() != null) {
				olderEmployee.setFirstName(employee.getFirstName());
			} else if (employee.getMiddleInitial() != null) {
				olderEmployee.setMiddleInitial(employee.getMiddleInitial());
			} else if (employee.getLastName() != null) {
				olderEmployee.setLastName(employee.getLastName());
			} else if (employee.getDateOfBirth() != null) {
				olderEmployee.setDateOfBirth(employee.getDateOfBirth());
			} else if (employee.getDateOfEmployment() != null) {
				olderEmployee.setDateOfEmployment(employee.getDateOfEmployment());
			} else if (employee.getStatus() != null) {
				olderEmployee.setStatus(employee.getStatus());
			}
			allEmployees.add(olderEmployee);
			return olderEmployee;
		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered in Employee DAO when trying to update Employee with id: " + id, x);
			throw new Exception("Could not successfully update this Employee, please try again.");
		}

		
	}
}