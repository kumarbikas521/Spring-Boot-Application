package com.spring.SpringBootApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralErrorMapper {
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<commonErrorMessage> mapError(InternalServerError err){
		commonErrorMessage error= new commonErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),err.getMessage());
	return new ResponseEntity<commonErrorMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
