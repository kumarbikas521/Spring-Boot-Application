package com.spring.SpringBootApp.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.SpringBootApp.entity.Employee;
@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AddEmployeeRepoTest {
	@Autowired
	AddEmployeeRepo addEmployeeRepo;

	Employee emp;

	@Before
	public void init() {
		emp = new Employee();
		emp.setAddress("kolkata");
		emp.setAge(25);
		emp.setName("bikas");
		emp.setSalary(50000);
	}

	@Test
	public void test() {
	
		addEmployeeRepo.save(emp);
		Employee e = addEmployeeRepo.findEmployeeByName("bikas");
		assertEquals(emp.getName(), e.getName());
	}

}
