package io.nsu.hire.apiemails.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sbogado on 7/18/17.
 */
@Data
@NoArgsConstructor
@Entity
public class EmailProperty {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	private String propertyKey;

	@NotNull
	@NotEmpty
	private String value;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "email_account_id")
	private EmailAccount emailAccount;

}


