package io.nsu.hire.apiauthserver.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
	private String name;
	private String lastName;
	private String password;
	private String email;
	private List<RoleDTO> roles;

}
