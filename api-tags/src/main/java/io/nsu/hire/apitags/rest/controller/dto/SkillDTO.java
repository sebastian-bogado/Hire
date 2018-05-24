package io.nsu.hire.apitags.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SkillDTO {

	private Long id;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String name;
	@NotNull
	@NotEmpty
	@Size(max = 1024)
	private String description;

}
