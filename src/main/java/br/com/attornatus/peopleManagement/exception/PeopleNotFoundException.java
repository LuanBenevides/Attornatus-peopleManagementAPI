package br.com.attornatus.peopleManagement.exception;

public class PeopleNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeopleNotFoundException(String message) {
		super(message);
	}
}
