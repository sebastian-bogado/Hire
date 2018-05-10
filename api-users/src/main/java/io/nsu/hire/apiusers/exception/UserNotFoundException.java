package io.nsu.hire.apiusers.exception;

public class UserNotFoundException extends NotFoundException {
	public UserNotFoundException(String email) {
		super(001, "user.not.found.exception.message", null, "user.not.found.exception.description", new String[]{email});
	}
}
