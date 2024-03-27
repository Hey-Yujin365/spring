package com.example.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.rest.RestResponse;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public RestResponse<Void> handleException(RuntimeException ex) {
		return RestResponse.getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
}
