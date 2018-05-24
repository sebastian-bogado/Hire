package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.model.Sector;
import io.nsu.hire.apitags.rest.controller.dto.SectorDTO;
import io.nsu.hire.apitags.service.SectorService;
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

@RequestMapping("/api/sectors")
@RestController
public class SectorRestController {

	@Autowired
	private SectorService sectorService;

	@Autowired
	private MapperFacade mapperFacade;

	@ApiOperation(value = "Get All sectors")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = SectorDTO.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@GetMapping
	public List<SectorDTO> getSectors() {
		return sectorService.getSectors().stream().map(element ->
				mapperFacade.map(element, SectorDTO.class)).collect(Collectors.toList());
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sector object", response = SectorDTO.class)
	})
	@GetMapping(path = "/{id}")
	public @ResponseBody
	SectorDTO getSector(@PathVariable("id") @NotNull Long id) {
		return mapperFacade.map(sectorService.getSectorById(id), SectorDTO.class);
	}

	@ApiOperation(value = "Insert sector. The name should be unique")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Sector.class),
			@ApiResponse(code = 404, message = "Resource not found"),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@PostMapping
	public SectorDTO createSector(@ApiParam(value = "Sector object", required = true, name = "sector") @NotNull @RequestBody @Valid SectorDTO sectorDTO) {
		return mapperFacade.map(sectorService.createSector(mapperFacade.map(sectorDTO, Sector.class)), SectorDTO.class);
	}

	@ApiOperation(value = "Update the Sector. The name should be unique")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Sector.class),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@PutMapping
	public SectorDTO updateSector(@ApiParam(value = "Sector object", required = true, name = "sector") @NotNull @RequestBody @Valid SectorDTO sectorDTO) {
		return mapperFacade.map(sectorService.updateSector(mapperFacade.map(sectorDTO, Sector.class)), SectorDTO.class);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "The sector was deleted")
	})
	@DeleteMapping(value = "/{id}")
	public void deleteSector(@PathVariable("id") @NotNull Long id) {
		sectorService.deleteSector(id);
	}

}