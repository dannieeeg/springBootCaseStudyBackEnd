package dev.gutierrez.exceptions;

public class ClaimNotFoundException extends RuntimeException{

	public ClaimNotFoundException(String message) {
		super(message);
	}
}
