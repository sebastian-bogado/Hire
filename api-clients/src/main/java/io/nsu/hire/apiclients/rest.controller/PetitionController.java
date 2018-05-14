package io.nsu.hire.apiclients.rest.controller;

import com.nsu.duhire.webapi.info.controller.client.dto.ClientPetitionRequest;
import com.nsu.duhire.webapi.info.controller.client.dto.ClientPetitionResponse;
import com.nsu.duhire.webapi.info.exception.CantCreateUserPetition;
import com.nsu.duhire.webapi.info.exception.UserExistException;
import com.nsu.duhire.webapi.info.exception.client.UserClientPetitionNotFoundException;
import com.nsu.duhire.webapi.info.model.ClientUserPetition;
import com.nsu.duhire.webapi.info.service.client.ClientUserPetitionService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/petition/client")
@RestController
public class PetitionController {

	@Autowired
	private MapperFacade orikaMapper;
	@Autowired
	private ClientUserPetitionService clientUserPetitionService;

	@GetMapping
	public List<ClientPetitionResponse> getAllPetitions() {
		return orikaMapper.mapAsList(clientUserPetitionService.readAllClientUserPetitions(), ClientPetitionResponse.class);
	}

	@PostMapping
	public ClientPetitionResponse createPetition(@Valid @NotNull ClientPetitionRequest clientPetitionRequest) throws CantCreateUserPetition, UserExistException {
		return orikaMapper.map(clientUserPetitionService.createUserPetition(orikaMapper.map(clientPetitionRequest, ClientUserPetition.class)), ClientPetitionResponse.class);
	}

	@GetMapping("/{uuid}")
	public ClientPetitionResponse getPetitionResponseByUuid(@NotNull @PathVariable("uuid") String uuid) throws UserClientPetitionNotFoundException {
		return orikaMapper.map(clientUserPetitionService.readClientUserPetitionByUuid(uuid), ClientPetitionResponse.class);
	}

}
