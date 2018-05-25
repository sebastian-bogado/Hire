package io.nsu.hire.apitags.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Country extends BaseBean {
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String name;
	@NotNull @NotEmpty
	@Column(unique = true)
	private String code;
	@NotNull @NotEmpty
	private String phonePrefix;
}
