package com.webservices.restfullApi.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions( Exception ex , WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails( LocalDate.now() , ex.getMessage(), request.getDescription(false) ); 
		
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR ) ; 
				
	}

}
