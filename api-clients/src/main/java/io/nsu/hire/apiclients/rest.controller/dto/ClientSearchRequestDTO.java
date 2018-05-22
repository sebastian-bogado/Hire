package io.nsu.hire.apiclients.rest.controller.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ClientSearchRequestDTO extends ClientListSearchRequestDTO {

	@NotNull
	@NotEmpty
	@Size(max = 2048)
	private String description;
	@NotNull
	private BigDecimal salaryFrom;
	@NotNull
	private BigDecimal salaryTo;
	private String workPlace;
	private String workMode;


}
