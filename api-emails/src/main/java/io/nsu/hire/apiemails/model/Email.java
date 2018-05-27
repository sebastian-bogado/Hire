package io.nsu.hire.apiemails.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by sbogado on 7/18/17.
 */
@Data
@NoArgsConstructor
@Entity
public class Email {
	@Id
	@GeneratedValue
	private Long id;

	@ElementCollection
	@CollectionTable(name = "receptores", joinColumns = @JoinColumn(name = "email_id"))
	@Column(name = "email")
	@NotNull
	@NotEmpty
	private List<String> direcciones;

	@ElementCollection
	@CollectionTable(name = "copia", joinColumns = @JoinColumn(name = "email_id"))
	@Column(name = "email")
	private List<String> direccionesCCO;

	@ElementCollection
	@CollectionTable(name = "receptores", joinColumns = @JoinColumn(name = "email_id"))
	@Column(name = "email")
	private List<String> direccionesCC;

	@NotNull
	@NotEmpty
	@Lob
	@Column(length = 65535)
	private String cuerpo;

	@NotNull
	@NotEmpty
	private String asunto;

	@NotNull
	@NotEmpty
	private String sendBy;

}