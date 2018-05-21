package io.nsu.hire.apiusers.controller;

import io.nsu.hire.apiusers.controller.dto.CreateUserRequestDTO;
import io.nsu.hire.apiusers.controller.dto.UpdateUserRequestDTO;
import io.nsu.hire.apiusers.controller.dto.UserDTO;
import io.nsu.hire.apiusers.controller.dto.UserListDTO;
import io.nsu.hire.apiusers.exception.UserNotFoundException;
import io.nsu.hire.apiusers.model.User;
import io.nsu.hire.apiusers.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class UserClientRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	@PreAuthorize("hasAuthority('GET_CLIENT_LIST_USER')")
	public List<UserListDTO> readClientUsers(@RequestParam("active") Boolean active) {
		return orikaMapper.mapAsList(userService.readAllClientUsers(active), UserListDTO.class);
	}

	@PostMapping
	public UserDTO createClientUser(@RequestBody @NotNull @Valid CreateUserRequestDTO request) {
		return orikaMapper.map(userService.createUser(orikaMapper.map(request, User.class)), UserDTO.class);
	}

	@PutMapping
	public UserDTO updateClientUser(@RequestBody @NotNull @Valid UpdateUserRequestDTO request) {
		return orikaMapper.map(userService.updateUser(orikaMapper.map(request, User.class)), UserDTO.class);
	}


}
