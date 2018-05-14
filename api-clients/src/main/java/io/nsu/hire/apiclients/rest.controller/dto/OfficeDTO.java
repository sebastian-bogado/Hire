package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class OfficeDTO {

	private Long id;
	@NotNull
	private ContactDTO clientDTO;
	@NotNull
	private AddressDTO addressDTO;
	@NotNull
	@NotEmpty
	private String officeName;

}
