package io.nsu.hire.apitags.exception;

import org.springframework.http.HttpStatus;

public abstract class BadFormatEntityException extends BusinessException {
	public BadFormatEntityException(String code, String message, String[] messageArguments, String description, String[] descriptionArguments) {
		super(code, message, messageArguments, description, descriptionArguments, HttpStatus.BAD_REQUEST);
	}
}
