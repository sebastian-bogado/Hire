package io.nsu.hire.apiusers.exception;

public class UserApplicationExistException extends ElementExistException {
	public UserApplicationExistException() {
		super("001", "user.application.exist.exception.message", null, "user.application.exist.exception.description", null);
	}
}
