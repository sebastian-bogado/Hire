package io.nsu.hire.apiclients.exception;

public class ClientExistException extends ElementExistException {

	public ClientExistException(String taxId) {
		super("001","", null, "", new String[]{taxId});
	}
}
