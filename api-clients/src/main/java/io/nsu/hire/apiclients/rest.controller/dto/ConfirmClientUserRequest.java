package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ConfirmClientUserRequest extends ClientPetitionRequest {

	@NotNull
	private String uuid;
	@NotNull
	private String password;
	@NotNull
	private String repeatPassword;

}
