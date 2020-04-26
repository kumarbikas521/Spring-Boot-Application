package com.spring.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBootApp.repository.DeleteEmployeeInterface;
@Service
public class DeleteEmployeeServiceImp implements DeleteServive{
	
	@Autowired
	DeleteEmployeeInterface deleteEmployeeInterface;

	  public String  deleteAllEmployee() {
		 try {
			 deleteEmployeeInterface.deleteAll();
			return ("All Employee deleted successfully...");
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			return ("Can't delete at this point .. problem in service..");
			
			
		}
		
	}

}
