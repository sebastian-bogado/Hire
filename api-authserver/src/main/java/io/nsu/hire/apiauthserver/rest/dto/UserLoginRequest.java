package io.nsu.hire.apiauthserver.rest.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
	private String username;
	private String password;
}
