package com.spring.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.repository.AddEmployeeRepo;

@Service
public class AddEmployeeServiceImp implements AddEmployeeService {

	@Autowired
	AddEmployeeRepo addEmployeeRepo;


	@Override
	public Employee addEmployee(Employee employeeRequestEvent) {
		Employee em = addEmployeeRepo.save(employeeRequestEvent);
		return em;
	}

}
