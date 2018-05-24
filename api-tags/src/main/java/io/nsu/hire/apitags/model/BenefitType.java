package io.nsu.hire.apitags.model;

public enum BenefitType {

	FAMILIAR("familiar.benefit.message"),
	IN_OFFICE("inOffice.benefit.message"),
	SEMANAL("semanal.benefit.message");

	private String message;

	BenefitType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
