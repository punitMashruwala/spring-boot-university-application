package com.example.mongo_task.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)

public class ApiErrorException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ApiErrorException(String message) {
		super(message);
	}
}
