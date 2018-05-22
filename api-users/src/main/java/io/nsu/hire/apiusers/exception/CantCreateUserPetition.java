package io.nsu.hire.apiusers.exception;

import org.springframework.http.HttpStatus;

public class CantCreateUserPetition extends BusinessException {
	public CantCreateUserPetition() {
		super("001", "", null, "", null, HttpStatus.CONFLICT);
	}
}
