package com.na.fbqs.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.na.fbqs.exception.NoSuchQueueException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchQueueException.class)
	public ResponseEntity<Error> handleNoSuchQueueException(NoSuchQueueException exception){		
		return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
