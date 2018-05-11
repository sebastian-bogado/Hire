package io.nsu.hire.apiusers.controller;

import io.nsu.hire.apiusers.controller.dto.UserAuthenticatedDTO;
import io.nsu.hire.apiusers.controller.dto.UserLoginRequestDTO;
import io.nsu.hire.apiusers.exception.UserNotFoundException;
import io.nsu.hire.apiusers.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/authentication")
public class AuthenticateRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private MapperFacade orikaMapper;


	@PostMapping
	public UserAuthenticatedDTO getUser(@RequestBody @NotNull @Valid UserLoginRequestDTO request) {
		return orikaMapper.map(userService
						.readUserByEmailAndPassword(request.getUsername(), request.getPassword()).orElseThrow(()-> new UserNotFoundException(request.getUsername())),
					UserAuthenticatedDTO.class);
	}
}
