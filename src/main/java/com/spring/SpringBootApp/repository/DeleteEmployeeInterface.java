package com.spring.SpringBootApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.SpringBootApp.entity.Employee;



@Repository
public interface DeleteEmployeeInterface extends CrudRepository<Employee, Integer> {

}
