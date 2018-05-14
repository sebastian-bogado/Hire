package io.nsu.hire.apiclients.exception;


public class UserClientPetitionNotFoundException extends NotFoundException {
	public UserClientPetitionNotFoundException(String uuid) {
		super(001,"",null, "", new String[]{uuid});
	}
}
