package com.racedriverlife.racedriverlife_app.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.RaceNotFoundException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;
import com.racedriverlife.racedriverlife_app.services.exceptions.UserAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class) 
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserAlreadyExistsException.class) 
	public ResponseEntity<StandardError> userAlreadyExists(UserAlreadyExistsException e, HttpServletRequest request) {
		String error = "Username conflict";
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(RaceNotFoundException.class) 
	public ResponseEntity<StandardError> raceNotFound(RaceNotFoundException e, HttpServletRequest request) {
		String error = "Race doesn't exists";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
