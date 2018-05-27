package io.nsu.hire.apiemails.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class EmailDTO {

	@NotNull
	@NotEmpty
	private String emailTemplate;

	@NotNull
	private Object data;

	@NotNull
	@NotEmpty
	private List<String> direcciones;

	private List<String> direccionesCCO;

	private List<String> direccionesCC;
}
