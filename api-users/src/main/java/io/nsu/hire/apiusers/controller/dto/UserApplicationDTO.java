package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

@Data
public class UserApplicationDTO {
	private String uuid;
	private String email;
	private String name;
	private String lastName;
	private String taxId;
}
