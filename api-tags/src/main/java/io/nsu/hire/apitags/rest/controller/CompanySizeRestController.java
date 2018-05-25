package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.rest.controller.dto.CompanySizeDTO;
import io.nsu.hire.apitags.service.CompanySizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/company-size")
public class CompanySizeRestController {
	@Autowired
	private CompanySizeService companySizeService;

	@GetMapping
	public List<CompanySizeDTO> getCompanySizes() {
		return companySizeService.readAllCompanySizes()
				.stream().map(companySize -> new CompanySizeDTO(companySize.name(), companySize.getMessage()))
				.collect(Collectors.toList());
	}

}
