package io.nsu.hire.apiclients.rest.controller;

import com.nsu.duhire.webapi.info.controller.client.dto.CreateClientUserRequest;
import com.nsu.duhire.webapi.info.exception.UserExistException;
import com.nsu.duhire.webapi.info.exception.client.ClientExistException;
import com.nsu.duhire.webapi.info.model.Client;
import com.nsu.duhire.webapi.info.model.User;
import com.nsu.duhire.webapi.info.service.client.ClientUserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/user")
public class ClientUserRestController {
	@Autowired
	private ClientUserService clientUserService;
	@Autowired
	private MapperFacade orikaMapper;

	@PostMapping
	private User createClientUser(CreateClientUserRequest request) throws ClientExistException, UserExistException {
		return clientUserService.createClientUser(request.getPetitionId(),
				orikaMapper.map(request, Client.class),
				orikaMapper.map(request, User.class));
	}


}
