package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ClientListSearchRequestDTO {

	private Long id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	private Long quantity;
	private Date created;

}
