package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class ClientPetitionRequest {

	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String taxId;
	@NotNull
	@NotEmpty
	private String companyName;

}
