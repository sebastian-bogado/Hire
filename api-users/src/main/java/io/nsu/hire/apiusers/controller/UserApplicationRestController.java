package io.nsu.hire.apiusers.controller;

import io.nsu.hire.apiusers.controller.dto.CreateUserApplicationRequest;
import io.nsu.hire.apiusers.controller.dto.UserApplicationDTO;
import io.nsu.hire.apiusers.exception.UserApplicationNotFound;
import io.nsu.hire.apiusers.model.UserApplication;
import io.nsu.hire.apiusers.service.UserApplicationService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/application")
public class UserApplicationRestController {

	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private MapperFacade orikaMapper;

	@GetMapping
	public Page<UserApplicationDTO> getUserApplications(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		Page<UserApplication> pageRequested = userApplicationService.readUserApplications(size, page);
		return new PageImpl<>(orikaMapper.mapAsList(pageRequested.getContent(), UserApplicationDTO.class), pageRequested.getPageable(), pageRequested.getTotalElements());
	}

	@GetMapping("/{uuid}")
	public UserApplicationDTO getUserApplication(@PathVariable("uuid") @NotNull String uuid) {
		return orikaMapper.map(userApplicationService.readUserApplicationByUuid(uuid).orElseThrow(() -> new UserApplicationNotFound(uuid)),UserApplicationDTO.class);
	}

	@PostMapping
	public void createUserApplication(@RequestBody  @NotNull @Valid CreateUserApplicationRequest request) {
		userApplicationService.createUserApplication(orikaMapper.map(request, UserApplication.class));
	}

}
