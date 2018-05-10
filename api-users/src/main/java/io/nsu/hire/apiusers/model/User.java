package io.nsu.hire.apiusers.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User extends LogicalDeleteableBean {

	private String name;
	private String lastName;
	private String email;
	private String password;
	private Date lastLogin;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles;
	@NotNull
	private Boolean locked;
	@NotNull
	private Integer badLogin;

}
