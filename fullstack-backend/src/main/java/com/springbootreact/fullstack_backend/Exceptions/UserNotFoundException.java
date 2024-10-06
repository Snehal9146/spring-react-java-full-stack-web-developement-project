package com.springbootreact.fullstack_backend.Exceptions;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3546494008163162738L;

	public UserNotFoundException(Long id) {
		super("Could not found the user with id "+id);
	}
}
