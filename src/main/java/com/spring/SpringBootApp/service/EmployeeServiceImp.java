package com.spring.SpringBootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.exception.InternalServerError;
import com.spring.SpringBootApp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() throws InternalServerError {
		// System.out.println("in service imp...");
		List<Employee> employee = employeeRepository.findAll();
		return employee;

	}

	@Override
	public Employee getUserById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.getEmployeeById(id);
		return employee;
	}

	@Override
	public Employee updateEmployeById(Employee emp ,int id) {
 		Employee e= employeeRepository.getEmployeeById(id);
 		e.setAddress(emp.getAddress());
 		e.setAge(emp.getAge());
 		e.setName(emp.getName());
 		e.setSalary(emp.getSalary());
		return employeeRepository.save(e);
 		
	}

}
