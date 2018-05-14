package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class ContactDTO {

	@NotNull
	@NotEmpty
	private String contactName;
	@NotNull
	@NotEmpty
	private String contactEmail;
	@NotNull
	@NotEmpty
	private String contactPosition;
	@NotNull
	@NotEmpty
	private String contactPhone;

}
