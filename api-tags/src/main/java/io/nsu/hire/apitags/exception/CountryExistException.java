package io.nsu.hire.apitags.exception;

public class CountryExistException extends ElementExistException {

	public CountryExistException(String name) {
		super("001","country.exist.exception.message", null, "country.exist.exception.description", new String[]{name});
	}

}
