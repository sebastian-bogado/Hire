package io.nsu.hire.apiclients.exception;

import com.nsu.duhire.webapi.info.exception.ElementExistException;

public class ClientExistException extends ElementExistException {

	public ClientExistException(String taxId) {
		super(001,"", null, "", new String[]{taxId});
	}
}
