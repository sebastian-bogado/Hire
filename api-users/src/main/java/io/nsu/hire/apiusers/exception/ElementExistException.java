package io.nsu.hire.apiusers.exception;

import org.springframework.http.HttpStatus;

public class ElementExistException extends BusinessException {

	public ElementExistException(Integer code, String messageCode, String[] messageArgs, String descriptionCode, String[] descriptionArgs) {
		super(code, messageCode, messageArgs, descriptionCode, descriptionArgs, HttpStatus.CONFLICT);
	}

}
