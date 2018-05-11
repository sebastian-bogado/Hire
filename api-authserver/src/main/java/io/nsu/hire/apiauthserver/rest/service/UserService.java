package io.nsu.hire.apiauthserver.rest.service;

import io.nsu.hire.apiauthserver.rest.dto.UserDTO;

import java.util.Optional;

public interface UserService {
	Optional<UserDTO> readUserByEmail(String username);
}
