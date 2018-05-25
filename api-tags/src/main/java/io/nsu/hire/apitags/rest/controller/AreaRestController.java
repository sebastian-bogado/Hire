package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.exception.AreaNotFoundException;
import io.nsu.hire.apitags.model.Area;
import io.nsu.hire.apitags.rest.controller.dto.AreaDTO;
import io.nsu.hire.apitags.service.AreaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/areas")
@RestController
public class AreaRestController {

	@Autowired
	private AreaService areaService;

	@Autowired
	private MapperFacade mapperFacade;

	@ApiOperation(value = "Get All areas")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = AreaDTO.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@GetMapping
	public List<AreaDTO> getAreas() {
		return areaService.getAreas().stream().map(element ->
				mapperFacade.map(element, AreaDTO.class)).collect(Collectors.toList());
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Area object", response = AreaDTO.class)
	})
	@GetMapping(path = "/{id}")
	public @ResponseBody
	AreaDTO getArea(@PathVariable("id") @NotNull Long id) {
		return mapperFacade.map(areaService.getAreaById(id).orElseThrow(() -> new AreaNotFoundException(id.toString())), AreaDTO.class);
	}

	@ApiOperation(value = "Insert sector. The name should be unique")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Area.class),
			@ApiResponse(code = 404, message = "Resource not found"),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@PostMapping
	public AreaDTO createArea(@ApiParam(value = "Area object", required = true, name = "sector") @NotNull @RequestBody @Valid AreaDTO areaDTO) {
		return mapperFacade.map(areaService.createArea(mapperFacade.map(areaDTO, Area.class)), AreaDTO.class);
	}

	@ApiOperation(value = "Update the Area. The name should be unique")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Area.class),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@PutMapping
	public AreaDTO updateArea(@ApiParam(value = "Area object", required = true, name = "sector") @NotNull @RequestBody @Valid AreaDTO areaDTO) {
		return mapperFacade.map(areaService.updateArea(mapperFacade.map(areaDTO, Area.class)), AreaDTO.class);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "The sector was deleted")
	})
	@DeleteMapping(value = "/{id}")
	public void deleteArea(@PathVariable("id") @NotNull Long id) {
		areaService.deleteArea(id);
	}

}