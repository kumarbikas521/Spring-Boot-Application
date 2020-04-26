package com.spring.SpringBootApp.service;


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.repository.AddEmployeeRepo;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeServiceImpTest {
	@Mock
	AddEmployeeRepo addEmployeeRepo;
	@InjectMocks
	AddEmployeeServiceImp addEmployeeService;
	Employee emp;

	@Before
	public void init() {
		emp = new Employee(1, "bikas", 26, "Dighwa duabuli", 50000);
	}

	@Test
	public void addEmployeeTest() {
		Mockito.when(addEmployeeRepo.save(emp)).thenReturn(emp);
		Employee e = addEmployeeService.addEmployee(emp);
		Assert.assertNotNull(e);
		assertEquals("bikas", e.getName());
		Mockito.verify(addEmployeeRepo, Mockito.times(1)).save(emp);

	}

}
