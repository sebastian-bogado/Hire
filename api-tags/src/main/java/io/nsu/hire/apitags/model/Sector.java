package io.nsu.hire.apitags.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@SQLDelete(sql = "UPDATE sector SET active = 0 WHERE id=?")
@Where(clause = "active=1")
public class Sector extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String name;

	@Column(length = 512)
	private String description;

}
