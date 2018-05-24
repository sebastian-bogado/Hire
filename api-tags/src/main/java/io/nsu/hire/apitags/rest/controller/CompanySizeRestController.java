package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.service.CompanySizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company-size")
public class CompanySizeRestController {
	@Autowired
	private CompanySizeService companySizeService;


}
