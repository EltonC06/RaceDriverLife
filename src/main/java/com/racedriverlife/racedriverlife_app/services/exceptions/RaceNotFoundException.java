package com.racedriverlife.racedriverlife_app.services.exceptions;

public class RaceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RaceNotFoundException(Object id) {
		super("Race doesn't exists. Id " + id);
	}

	
}
