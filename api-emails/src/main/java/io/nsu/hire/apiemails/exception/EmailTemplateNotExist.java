package io.nsu.hire.apiemails.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by sbogado on 7/18/17.
 */
public class EmailTemplateNotExist extends BusinessException {
	public EmailTemplateNotExist(String[] messageArgs) {
		super("exception.email.template.not.found", null, HttpStatus.NOT_FOUND, null, null);
	}
}

