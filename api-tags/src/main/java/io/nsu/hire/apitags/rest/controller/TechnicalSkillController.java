package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.exception.TechSkillNotFoundException;
import io.nsu.hire.apitags.model.TechnicalSkill;
import io.nsu.hire.apitags.rest.controller.dto.SkillDTO;
import io.nsu.hire.apitags.service.TechnicalSkillService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/tech-skills")
public class TechnicalSkillController {


	@Autowired
	private TechnicalSkillService technicalSkillService;
	@Autowired
	private MapperFacade mapperFacade;

	@GetMapping()
	public List<SkillDTO> getSkills() {
		return mapperFacade.mapAsList(technicalSkillService.readAllTechSkills(), SkillDTO.class);
	}

	@GetMapping("/{id}")
	public SkillDTO getSkillDTO(@PathVariable("id") Long id) {
		return mapperFacade.map(technicalSkillService.readTechnicalSkillById(id).orElseThrow(() -> new TechSkillNotFoundException(id.toString())), SkillDTO.class);
	}

	@PostMapping()
	public SkillDTO createSkillDTO(@RequestBody @NotNull @Valid SkillDTO skillDTO) {
		return mapperFacade.map(technicalSkillService.createTechnicalSkill(mapperFacade.map(skillDTO, TechnicalSkill.class)), SkillDTO.class);
	}

	@PutMapping()
	public SkillDTO updateSkillDTO(@RequestBody @NotNull @Valid SkillDTO skillDTO) {
		return mapperFacade.map(technicalSkillService.updateTechnicalSkill(mapperFacade.map(skillDTO, TechnicalSkill.class)), SkillDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteSoftSkill(@PathVariable("id") Long id) {
		technicalSkillService.deleteTechnicalSkillById(id);
	}

}