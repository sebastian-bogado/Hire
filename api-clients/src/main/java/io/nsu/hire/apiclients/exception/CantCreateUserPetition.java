package io.nsu.hire.apiclients.exception;

import org.springframework.http.HttpStatus;

public class CantCreateUserPetition extends BusinessException {
	public CantCreateUserPetition(){
		super(001,"",null, "", null, HttpStatus.CONFLICT);
	}
}
