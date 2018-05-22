package io.nsu.hire.apiclients.rest.controller;

import io.nsu.hire.apiclients.model.Client;
import io.nsu.hire.apiclients.rest.controller.dto.ClientDTO;
import io.nsu.hire.apiclients.rest.controller.dto.ClientListDTO;
import io.nsu.hire.apiclients.rest.controller.dto.CreateClientUserRequest;
import io.nsu.hire.apiclients.rest.controller.dto.UpdateClientRequest;
import io.nsu.hire.apiclients.service.ClientService;
import io.nsu.hire.apiclients.vo.UserVO;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	public Page<ClientListDTO> readClientPage(@PathParam("size") Integer size, @PathParam("page") Integer page) {
		Page<Client> clientsPage = clientService.readClients(size, page);
		return new PageImpl<>(orikaMapper.mapAsList(clientsPage.getContent(), ClientListDTO.class),clientsPage.getPageable(), clientsPage.getTotalElements());
	}

	@GetMapping("/{id}")
	public ClientDTO readClient(@NotNull @PathVariable("id")Long id) {
		return orikaMapper.map(clientService.readClientById(id), ClientDTO.class);
	}

	@PostMapping
	public ClientDTO createClient(@RequestBody @NotNull @Valid CreateClientUserRequest request) {
		return orikaMapper.map(clientService.createClient(orikaMapper.map(request, Client.class)), ClientDTO.class);
	}

	@PutMapping
	public ClientDTO updateClient(@RequestBody @Valid @NotNull UpdateClientRequest request) {
		return orikaMapper.map(clientService.createClient(orikaMapper.map(request, Client.class)), ClientDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		clientService.deleteClient(id);
	}

}
