package io.nsu.hire.apitags.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class Skill extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String skillName;
	@NotNull
	@NotEmpty
	@Column(length = 1024)
	private String description;

}
