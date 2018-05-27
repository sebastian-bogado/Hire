package io.nsu.hire.apiemails.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by sbogado on 7/17/17.
 */
@Data
@NoArgsConstructor
@Entity
public class EmailTemplate {
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String subject;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String name;

	@NotNull
	@NotEmpty
	private String path;

	@ManyToOne
	private EmailAccount emailAccount;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "email_template_images", joinColumns = @JoinColumn(name = "email_template_id"))
	@MapKeyColumn(name = "key_name", length = 50)
	@Column(name = "image_path", length = 100)
	@BatchSize(size = 20)
	private Map<String, String> images;

}
