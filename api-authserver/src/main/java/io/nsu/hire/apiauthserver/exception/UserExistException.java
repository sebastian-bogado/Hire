package io.nsu.hire.apiauthserver.exception;

public class UserExistException extends ElementExistException {

	public UserExistException(String username) {
		super(01404001,"", null, "", new String[]{username});
	}
}
