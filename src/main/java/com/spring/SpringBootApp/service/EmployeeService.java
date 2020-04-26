package com.spring.SpringBootApp.service;

import java.util.List;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.exception.InternalServerError;

public interface EmployeeService {

	List<Employee> getAllEmployee() throws InternalServerError;

	Employee getUserById(int id);

	Employee updateEmployeById(Employee emp ,int id);
	
	

}
