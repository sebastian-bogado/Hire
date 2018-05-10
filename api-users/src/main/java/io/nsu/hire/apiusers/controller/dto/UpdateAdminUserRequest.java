package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

@Data
public class UpdateAdminUserRequest extends CreateAdminUserRequest {
	private Long id;
}
