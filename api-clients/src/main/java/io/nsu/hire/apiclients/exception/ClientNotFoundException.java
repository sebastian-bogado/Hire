package io.nsu.hire.apiclients.exception;

public class ClientNotFoundException extends NotFoundException {

	private static final Integer CODE = 001;

	public ClientNotFoundException(String uuid) {
		super(CODE, "",null, "", new String[]{uuid});
	}

	public ClientNotFoundException(Long id) {
		super(CODE,"",null, "", new String[]{id.toString()});
	}

}
