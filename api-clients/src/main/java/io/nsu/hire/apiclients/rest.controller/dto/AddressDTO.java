package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {
	@NotNull
	@NotEmpty
	private String street;
	@NotNull
	@NotEmpty
	private String postalCode;
	@NotNull
	@NotEmpty
	private String number;
	@NotNull
	@NotEmpty
	private String city;
	@NotNull
	private Long countryId;
	@NotNull
	@NotEmpty
	private String details;
}
