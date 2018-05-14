package io.nsu.hire.apiauthserver.exception;

public class UserNotFoundException extends NotFoundException {
	public UserNotFoundException(String email) {
		super(0140401,"",null, "", new String[]{email});
	}
}
