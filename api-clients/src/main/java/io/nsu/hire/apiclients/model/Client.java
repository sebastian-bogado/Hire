package io.nsu.hire.apiclients.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@SQLDelete(sql = "UPDATE TABLE CLIENT SET active = false WHERE id = ?")
public class Client extends LogicalDeleteableBean {

	@NotNull
	@NotEmpty
	private String fiscalName;
	@NotNull
	@NotEmpty
	private String fiscalId;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String email;
	@Enumerated(EnumType.STRING)
	private CompanySizeEnum companySize;
	@ManyToOne(fetch = FetchType.EAGER)
	private Long sectorId;
	@NotNull
	@NotEmpty
	private String contactName;
	@NotNull
	@NotEmpty
	private String contactPosition;
	@NotNull
	@NotEmpty
	private String contactPhone;
	@NotNull
	@NotEmpty
	private String contactEmail;

}
