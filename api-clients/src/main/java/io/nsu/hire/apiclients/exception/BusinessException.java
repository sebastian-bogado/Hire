package io.nsu.hire.apiclients.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BusinessException extends RuntimeException {

	private String code;
	private String message;
	private String[] messageArguments;
	private String description;
	private String[] descriptionArguments;
	private HttpStatus status;

}