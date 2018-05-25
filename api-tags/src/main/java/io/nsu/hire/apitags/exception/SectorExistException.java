package io.nsu.hire.apitags.exception;


public class SectorExistException extends ElementExistException {

	public SectorExistException(String name) {
		super("001", "sector.exist.exception.message", null, "sector.exist.exception.description", new String[]{name});
	}

}
