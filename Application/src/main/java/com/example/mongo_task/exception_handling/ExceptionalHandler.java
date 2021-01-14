package com.example.mongo_task.exception_handling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice

public class ExceptionalHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> recordNotFoundException(ResourceNotFoundException exception, WebRequest request){
		ErrorHandlingDetails errorObject = new ErrorHandlingDetails(new Date(), exception.getMessage(), 404, request.getDescription(false));
		return new ResponseEntity(errorObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ApiErrorException.class)
	public ResponseEntity<?> apiErrorException(ApiErrorException exception, WebRequest request){
		ErrorHandlingDetails errorObject = new ErrorHandlingDetails(new Date(), "Please Check API Url", 400, request.getDescription(false));
		return new ResponseEntity(errorObject, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errorException(Exception exception, WebRequest request){
		ErrorHandlingDetails errorObject = new ErrorHandlingDetails(new Date(), exception.getMessage(), 500, request.getDescription(false));
		return new ResponseEntity(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
