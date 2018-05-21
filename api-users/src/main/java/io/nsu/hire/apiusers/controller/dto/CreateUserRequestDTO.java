package io.nsu.hire.apiusers.controller.dto;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
