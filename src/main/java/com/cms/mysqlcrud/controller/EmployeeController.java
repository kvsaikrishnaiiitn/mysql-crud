package com.cms.mysqlcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.mysqlcrud.model.Employee;
import com.cms.mysqlcrud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Object> getEmployee(@PathVariable("employeeId") Long employeeId) {
		Employee employeeById = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Object> findAllEmployees() {
		List<Employee> allEmployees = employeeService.findAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
}
