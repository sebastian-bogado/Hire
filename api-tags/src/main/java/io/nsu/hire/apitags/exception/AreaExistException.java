package io.nsu.hire.apitags.exception;


public class AreaExistException extends ElementExistException {

	public AreaExistException(String name) {
		super("001", "area.exist.exception.message", null, "area.exist.exception.description", new String[]{name});
	}

}
