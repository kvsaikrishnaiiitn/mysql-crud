package com.cms.mysqlcrud.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cms.mysqlcrud.exception.EmployeeNotFound;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> handleEmployeeNotFounExceptionHandler(EmployeeNotFound employeeNotFound) {
		return new ResponseEntity<>(employeeNotFound, HttpStatus.NOT_FOUND);
	}

}
