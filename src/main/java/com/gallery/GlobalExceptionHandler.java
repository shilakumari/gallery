package com.gallery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		// logging Null Pointer Exception
		System.out.println("Exception occured: " + e);
		e.printStackTrace();
		return "exceptionPage";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleException2(NullPointerException e) {
		// logging NullPointerException
		System.out.println("Exception occured: " + e);
		return "exceptionPage";
	}
}
