package com.spring.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootApp.exception.ExceptionInDeleteById;
import com.spring.SpringBootApp.repository.DeleteEmployeeInterface;

@Service
public class DeleteEmployeeWithIdImp implements DeleteEmployeeWithId {

	@Autowired
	DeleteEmployeeInterface deleteEmployeeInterface;

	@Override
	public String deleteEmployeById(int id) {

		try {
			deleteEmployeeInterface.deleteById(id);
			return "Deleted successfully";
		} catch (Exception e) {

			ExceptionInDeleteById str = new ExceptionInDeleteById();
			return (str.toString());
		}

	}

}
