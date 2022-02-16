package com.assignment.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicatePurchaseExceptionController {
	@ExceptionHandler(value = DuplicatePurchaseException.class ) 
	public ResponseEntity<?> exception(DuplicatePurchaseException exception) {
		return new ResponseEntity<>(" Order already confirmed !!",HttpStatus.NOT_MODIFIED);
	}
	
}
