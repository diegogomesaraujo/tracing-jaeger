package com.github.diegogomesaraujo.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {

	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler({AddressNotFoundException.class})
	public ErrorDTO notFoundException(RuntimeException e) {
		return ErrorDTO.builder()
				.code(NOT_FOUND.value())
				.error(e.getMessage())
				.build();
	}
	
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public ErrorDTO genericException(RuntimeException e) {
		return ErrorDTO.builder()
				.code(INTERNAL_SERVER_ERROR.value())
				.error("An internal error has occurred")
				.build();
	}
	
}
