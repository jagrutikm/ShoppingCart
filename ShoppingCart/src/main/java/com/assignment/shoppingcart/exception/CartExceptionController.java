package com.assignment.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartExceptionController {
	@ExceptionHandler(value = CartNotFoundException.class ) 
	public ResponseEntity<?> exception(CartNotFoundException exception) {
		return new ResponseEntity<>(" Cart details not found",HttpStatus.NOT_FOUND);
	}
	
	

}
