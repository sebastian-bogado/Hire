package io.nsu.hire.apitags.rest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SectorDTO {

	private Long id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String description;

}
