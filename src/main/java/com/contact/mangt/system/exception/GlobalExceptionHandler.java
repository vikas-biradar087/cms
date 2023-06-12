package com.contact.mangt.system.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.contact.mangt.system.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	// handle specific exceptions
		@ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
	                                                                        WebRequest webRequest){
			
	        ApiResponse apiResponse = new ApiResponse(new Date(), exception.getMessage(),
	                webRequest.getDescription(false));
	        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
			
		}	
}
