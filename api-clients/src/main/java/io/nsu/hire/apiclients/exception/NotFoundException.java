package io.nsu.hire.apiclients.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public abstract class NotFoundException extends BusinessException {

	public NotFoundException(Integer code, String messageCode, String[] messageArgs, String descriptionCode, String[] descriptionArgs) {
		super(code, messageCode, messageArgs, descriptionCode, descriptionArgs, HttpStatus.NOT_FOUND);
	}

}
