package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.exception.CountryNotFoundException;
import io.nsu.hire.apitags.model.Country;
import io.nsu.hire.apitags.rest.controller.dto.CountryDTO;
import io.nsu.hire.apitags.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

	@Autowired
	private MapperFacade mapperFacade;
	@Autowired
	private CountryService countryService;


	@ApiOperation(value="Get All countries")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CountryDTO.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@GetMapping
	public List<CountryDTO> getAllCountries() {
		return mapperFacade.mapAsList(countryService.getCountries(), CountryDTO.class);
	}

	@GetMapping(value = "/{id}")
	@ApiResponses(value = {
			@ApiResponse(code=200,message = "The country was deleted")
	})
	public CountryDTO getCountry(@PathVariable("id") @NotNull Long id) {
		return mapperFacade.map(countryService.getCountryById(id).orElseThrow(() -> new CountryNotFoundException(id.toString())), CountryDTO.class);
	}

	@PostMapping
	public CountryDTO createCountry(@RequestBody @Valid CountryDTO countryDTO) {
		return mapperFacade.map(countryService.createCountry(mapperFacade.map(countryDTO, Country.class)), CountryDTO.class);
	}

	@ApiOperation(value="Update the country. The name should be unique")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Success", response = Country.class),
			@ApiResponse(code = 401, message = "You dont have access to this resource"),
			@ApiResponse(code = 403, message = "You dont have permissions to access to this source")})
	@PutMapping
	public CountryDTO updateArea(@RequestBody @Valid CountryDTO countryDTO) {
		return mapperFacade.map(countryService.updateCountry(mapperFacade.map(countryDTO, Country.class)), CountryDTO.class);
	}

	@ApiResponses(value = {
			@ApiResponse(code=204,message = "The country was deleted")
	})
	@DeleteMapping(value= "/{id}")
	public void deleteCountry(@PathVariable("id") @NotNull Long id) {
		countryService.deleteCountry(id);
	}

}