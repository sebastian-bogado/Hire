package io.nsu.hire.apiauthserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BusinessException extends RuntimeException {

	private Integer code;
	private String message;
	private String[] messageArguments;
	private String description;
	private String[] descriptionArguments;
	private HttpStatus status;

}