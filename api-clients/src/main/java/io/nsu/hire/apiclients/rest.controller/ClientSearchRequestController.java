package io.nsu.hire.apiclients.rest.controller;

import com.nsu.duhire.webapi.info.controller.client.dto.ClientListSearchRequestDTO;
import com.nsu.duhire.webapi.info.controller.client.dto.ClientSearchRequestDTO;
import com.nsu.duhire.webapi.info.exception.SearchRequestNotFoundException;
import com.nsu.duhire.webapi.info.exception.client.ClientNotFoundException;
import com.nsu.duhire.webapi.info.model.SearchRequest;
import com.nsu.duhire.webapi.info.service.client.ClientSearchRequestService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/client/search-request")
public class ClientSearchRequestController {

	@Autowired
	private MapperFacade orikaMapper;
	@Autowired
	private ClientSearchRequestService clientSearchRequestService;

	@GetMapping
	public List<ClientListSearchRequestDTO> getAllSearchRequest() throws ClientNotFoundException {
		return orikaMapper.mapAsList(clientSearchRequestService.readAllSearchRequest(), ClientListSearchRequestDTO.class);
	}

	@PostMapping
	public ClientSearchRequestDTO createSearchRequest(@NotNull @RequestBody @Valid ClientSearchRequestDTO request) {
		return orikaMapper.map(clientSearchRequestService.createRequest(orikaMapper.map(request, SearchRequest.class)),ClientSearchRequestDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteSearchRequest(@NotNull @PathVariable("id") Long id) {
		clientSearchRequestService.deleteSearchRequest(id);
	}

	@GetMapping("/{id}")
	public ClientSearchRequestDTO getSearchRequest(@NotNull @PathVariable("id") Long id) throws SearchRequestNotFoundException {
		return orikaMapper.map(clientSearchRequestService.readSearchRequestById(id), ClientSearchRequestDTO.class);
	}

}
