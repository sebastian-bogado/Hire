package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthenticatedDTO {
	private String name;
	private String lastName;
	private String email;
	private String password;
	private List<RoleDTO> roles;
}
