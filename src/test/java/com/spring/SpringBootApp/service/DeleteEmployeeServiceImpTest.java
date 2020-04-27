package com.spring.SpringBootApp.service;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.SpringBootApp.entity.Employee;
import com.spring.SpringBootApp.repository.DeleteEmployeeInterface;

@RunWith(MockitoJUnitRunner.class)
public class DeleteEmployeeServiceImpTest {
	@Mock
	DeleteEmployeeInterface deleteEmployeeInterface;
	@InjectMocks
	DeleteEmployeeServiceImp deleteEmployeeServiceImp;
	
	Employee emp;

	@Before
	public void inti() {
		emp = new Employee(1, "bikas", 26, "difghj", 546454);
	}

	@Test
	public void deleteEmployeByIdTest() {
		deleteEmployeeInterface.save(emp);
		deleteEmployeeInterface.deleteById(1);
		Mockito.verify(deleteEmployeeInterface,Mockito.times(1)).deleteById(1);
	}

}
