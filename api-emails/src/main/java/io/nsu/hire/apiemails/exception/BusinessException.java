package io.nsu.hire.apiemails.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public abstract class BusinessException extends Exception {

	private CustomError error;

	public BusinessException(String messageCode, String[] messageArgs, HttpStatus httpStatus, String descriptionCode, String[] descriptionArgs) {
		error = new CustomError(messageCode, messageArgs, httpStatus, descriptionCode, descriptionArgs);
	}
}
