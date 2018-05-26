package io.nsu.hire.apiclients.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public class LogicalDeleteableBean extends BaseBean {
	@NotNull
	private Boolean active;
}
