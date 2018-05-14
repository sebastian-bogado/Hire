package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class CreateClientUserRequest {

	@NotNull
	@NotEmpty
	private String name;
	private String sectorId;
	@NotNull
	@NotEmpty
	private String fiscalId;
	@NotNull
	@NotEmpty
	private String fiscalName;
	@NotNull
	private AddressDTO address;
	@NotNull
	private ContactDTO contactDTO;
	@NotNull
	private Long petitionId;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	private String confirmPassword;

}
