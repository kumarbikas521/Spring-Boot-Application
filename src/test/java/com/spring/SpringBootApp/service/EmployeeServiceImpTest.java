package com.spring.SpringBootApp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.exception.InternalServerError;
import com.spring.SpringBootApp.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImpTest {

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeServiceImp employeeServiceImp;

	Employee emp;

	List<Employee> empList = new ArrayList<Employee>();

	@Before
	public void init() {
		emp = new Employee(1, "bikas", 26, "dighwa", 50000);
		empList.add(emp);
		emp = new Employee(2, "kk", 24, "ranchi", 52000);
		empList.add(emp);
		emp = new Employee(3, "gyan", 29, "kolkata", 40000);
		empList.add(emp);

	}

	@Test
	public void getAllEmployeeTest() throws InternalServerError {
		Mockito.when(employeeRepository.findAll()).thenReturn(empList);
		List<Employee> li = employeeServiceImp.getAllEmployee();
		assertEquals(3, li.size());
		Assert.assertNotNull(li);
		Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void getUserByIdTest() {
		Mockito.when(employeeRepository.getEmployeeById(3)).thenReturn(emp);
		emp = employeeServiceImp.getUserById(3);
		assertNotNull(emp);
		assertEquals("gyan", emp.getName());
		Mockito.verify(employeeRepository, Mockito.times(1)).getEmployeeById(3);
	}

	@Test
	public void updateEmployeeTest() {
		Mockito.when(employeeRepository.getEmployeeById(3)).thenReturn(emp);
		Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
		Employee e = employeeServiceImp.updateEmployeById(emp, 3);
		assertNotNull(e);
		assertEquals("gyan", e.getName());
		Mockito.verify(employeeRepository, Mockito.times(1)).save(emp);
	}

}
