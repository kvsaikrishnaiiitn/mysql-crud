package com.cms.mysqlcrud.service;

import java.util.List;

import com.cms.mysqlcrud.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long employeeId);
	
	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long employeeId);
	
	List<Employee> findAllEmployees();
	
}
