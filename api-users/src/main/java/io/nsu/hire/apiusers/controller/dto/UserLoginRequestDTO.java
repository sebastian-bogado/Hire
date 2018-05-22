package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
	private String username;
	private String password;
}
