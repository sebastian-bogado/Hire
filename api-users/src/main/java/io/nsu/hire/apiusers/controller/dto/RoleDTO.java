package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {
	private String name;
	private List<PermissionDTO> permissions;
}
