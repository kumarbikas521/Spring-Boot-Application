package com.spring.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.SpringBootApp.entity.Employee;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findAll();

	Employee getEmployeeById(int id);

	//Employee save(Employee emp);
	
	
}
