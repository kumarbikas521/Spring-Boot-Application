package com.spring.SpringBootApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.SpringBootApp.entity.Employee;


@Repository
public interface AddEmployeeRepo extends CrudRepository<Employee, Integer> {
	Employee findById(int id);
	Employee findEmployeeByName(String name);

}
