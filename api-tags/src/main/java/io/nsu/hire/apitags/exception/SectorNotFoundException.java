package io.nsu.hire.apitags.exception;

public class SectorNotFoundException extends NotFoundException {

	public SectorNotFoundException(String areaIdentifier) {
		super("001", "sector.notfound.exception.message", null, "sector.notfound.exception.description", new String[]{areaIdentifier});
	}

}
