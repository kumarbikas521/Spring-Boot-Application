package com.spring.SpringBootApp.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBootApp.Annotation.TrackTime;
import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.exception.InternalServerError;
import com.spring.SpringBootApp.service.AddEmployeeService;
import com.spring.SpringBootApp.service.DeleteEmployeeWithId;
import com.spring.SpringBootApp.service.DeleteServive;
import com.spring.SpringBootApp.service.EmployeeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/employee")
 @Api(value = "Authentication Controller")
public class EmployeeController {

	@Autowired
	DeleteServive deleteServive;

	@Autowired
	DeleteEmployeeWithId deleteEmployeeWithId;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	AddEmployeeService addEmployeeService;
	
	@TrackTime
	@PostMapping("/addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee addEmployeeReqDomain) {
		Employee ear = (addEmployeeService.addEmployee(addEmployeeReqDomain));
		return new ResponseEntity<Employee>(ear, HttpStatus.OK);
	}

	@TrackTime
	@GetMapping("/all")
	List<Employee> getAllEmployee() throws InternalServerError {
		// System.out.println("controller......");
		List<Employee> employees = employeeService.getAllEmployee();
		return employees;

	}

	@GetMapping("/getUserById/{id}")
	Employee getUserById(@PathVariable int id) {

		Employee employeeResponseEvent = employeeService.getUserById(id);
		return employeeResponseEvent;

	}

	@DeleteMapping("deleteAll")
	@ResponseBody
	String deleteAllEmployee() {

		String dr = deleteServive.deleteAllEmployee();
		return dr;

	}

	@DeleteMapping("deleteById/{id}")
	@ResponseBody
	String deleteEmployeeById(@PathVariable("id") int id) {

		String dr = deleteEmployeeWithId.deleteEmployeById(id);

		return dr;

	}

	@PutMapping("/updateEmployee/{id}")
	Employee updateEmployeeById(@RequestBody Employee emp, @PathVariable("id") int id) {

		Employee emp1 = employeeService.updateEmployeById(emp, id);

		return emp1;

	}

}