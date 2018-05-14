package io.nsu.hire.apiclients.model;

@MappedSuperclass
@Data
public class LogicalDeleteableBean extends BaseBean {
	@NotNull
	private Boolean active;
}
