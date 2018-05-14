package io.nsu.hire.apiclients.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ClientUserPetition {

	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String taxId;
	@Enumerated(EnumType.STRING)
	private PetitionStatusEnum petitionStatusEnum;
	@NotNull
	@NotEmpty
	private String companyName;
}
