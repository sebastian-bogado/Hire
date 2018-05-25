package io.nsu.hire.apitags.model;

public enum CompanySizeEnum {
	SMALL("company.size.small"),
	MEDIUM("company.size.medium"),
	LARGE("company.size.large"),
	EXTRA_LARGE("company.size.extra.large");

	private String message;

	CompanySizeEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
