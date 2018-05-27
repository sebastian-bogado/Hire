package io.nsu.hire.apiemails.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by sbogado on 7/17/17.
 */
@Data
@NoArgsConstructor
@Entity
public class EmailAccount {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	@Size(max = 200)
	@Column(unique = true)
	private String emailAddress;

	@NotNull
	@NotEmpty
	@Size(max = 400)
	private String password;

	@OneToMany(mappedBy = "emailAccount", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<EmailProperty> properties;

}
