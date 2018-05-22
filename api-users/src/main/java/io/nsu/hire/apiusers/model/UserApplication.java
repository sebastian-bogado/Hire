package io.nsu.hire.apiusers.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class UserApplication extends BaseBean{

	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String taxId;
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserRoleEnum userRole;

}
