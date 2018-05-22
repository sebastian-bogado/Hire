package io.nsu.hire.apiusers.controller.dto;

import io.nsu.hire.apiusers.model.UserRoleEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserApplicationRequest {
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String taxId;
	@NotNull
	private UserRoleEnum userRole;
}
