package com.cms.mysqlcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.mysqlcrud.exception.EmployeeNotFound;
import com.cms.mysqlcrud.model.Employee;
import com.cms.mysqlcrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
		employeeById.orElseThrow(() -> new EmployeeNotFound("Unable to find employee with id:" + employeeId));
		return employeeById.get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeById = employeeRepository.findById(employee.getId());
		employeeById.orElseThrow(() -> new EmployeeNotFound("Unable to find employee with id:" + employee.getId()));
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
		employeeById.orElseThrow(() -> new EmployeeNotFound("Unable to find employee with id:" + employeeId));
		employeeRepository.delete(employeeById.get());
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		if (allEmployees.isEmpty()) {
			throw new EmployeeNotFound();
		}
		
		return employeeRepository.findAll();
	}
}
