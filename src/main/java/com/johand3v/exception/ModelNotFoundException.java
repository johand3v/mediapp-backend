package com.johand3v.exception;


//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}
