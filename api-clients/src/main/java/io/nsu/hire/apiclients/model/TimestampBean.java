package io.nsu.hire.apiclients.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class TimestampBean {
	@NotNull
	private Date creationDate;
	@NotNull
	private Date lastUpdate;
}
