package com.mars.rover.explorer.exceptions.handler

import com.mars.rover.explorer.exceptions.RoverRuntimeException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RoverExceptionHandler {

	@ExceptionHandler(RoverRuntimeException::class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	fun handleException(e: RoverRuntimeException): String? {
		return e.message
	}
}
