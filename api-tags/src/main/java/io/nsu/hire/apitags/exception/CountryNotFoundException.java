package io.nsu.hire.apitags.exception;

public class CountryNotFoundException extends NotFoundException {

	public CountryNotFoundException(String areaIdentifier) {
		super("001","country.notfound.exception.message", null, "country.notfound.exception.description", new String[]{areaIdentifier});
	}

}
