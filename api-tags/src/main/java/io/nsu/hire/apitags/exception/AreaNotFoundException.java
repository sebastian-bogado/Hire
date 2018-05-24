package io.nsu.hire.apitags.exception;

public class AreaNotFoundException extends NotFoundException {

	public AreaNotFoundException(String areaIdentifier) {
		super("001", "area.notfound.exception.message", null, "area.notfound.exception.description", new String[]{areaIdentifier});
	}

}
