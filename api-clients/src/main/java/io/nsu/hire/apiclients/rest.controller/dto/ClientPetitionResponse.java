package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;

@Data
public class ClientPetitionResponse {

	private String uuid;
	private String email;
	private String name;
	private String taxId;
	private String companyName;

}
