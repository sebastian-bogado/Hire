package io.nsu.hire.apitags.exception;

import org.springframework.http.HttpStatus;

public class ElementExistException extends BusinessException {

	public ElementExistException(String code, String messageCode, String[] messageArgs, String descriptionCode, String[] descriptionArgs) {
		super(code, messageCode, messageArgs, descriptionCode, descriptionArgs, HttpStatus.CONFLICT);
	}

}
