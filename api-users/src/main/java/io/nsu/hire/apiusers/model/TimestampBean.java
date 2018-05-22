package io.nsu.hire.apiusers.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class TimestampBean {
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdate;
}
