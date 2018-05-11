package io.nsu.hire.apiauthserver.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {
	private String name;
	private List<PermissionDTO> permissionList;
}
