package com.synechron.iap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex) {

		System.out.println("===============CustomExceptionHandler.handleUserNotFoundException()");
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
				System.currentTimeMillis());
		System.out.println("@@@@@@@@@@@@@@@CustomExceptionHandler.handleUserNotFoundException()"+ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllBadRequest(Exception ex) {
//		
//		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
//				System.currentTimeMillis());
//		
//		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
//	}

//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
//		
//		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(),
//				System.currentTimeMillis());
//		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
