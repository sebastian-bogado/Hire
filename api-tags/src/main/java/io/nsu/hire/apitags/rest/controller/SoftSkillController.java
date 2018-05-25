package io.nsu.hire.apitags.rest.controller;

import io.nsu.hire.apitags.exception.SoftSkillExistException;
import io.nsu.hire.apitags.exception.SoftSkillNotFoundException;
import io.nsu.hire.apitags.model.SoftSkill;
import io.nsu.hire.apitags.rest.controller.dto.SkillDTO;
import io.nsu.hire.apitags.service.SoftSkillService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/soft-skills")
public class SoftSkillController {


	@Autowired
	private SoftSkillService softSkillService;
	@Autowired
	private MapperFacade mapperFacade;

	@GetMapping()
	public List<SkillDTO> getSkills() {
		return mapperFacade.mapAsList(softSkillService.readAllSoftSkills(), SkillDTO.class);
	}

	@GetMapping("/{id}")
	public SkillDTO getSkillDTO(@PathVariable("id") Long id) throws SoftSkillNotFoundException {
		return mapperFacade.map(softSkillService.readSoftSkillById(id).orElseThrow(() -> new SoftSkillNotFoundException(id.toString())), SkillDTO.class);
	}

	@PostMapping()
	public SkillDTO createSkillDTO(@RequestBody @NotNull @Valid SkillDTO skillDTO) throws SoftSkillExistException {
		return mapperFacade.map(softSkillService.createSoftSkill(mapperFacade.map(skillDTO, SoftSkill.class)), SkillDTO.class);
	}

	@PutMapping()
	public SkillDTO updateSkillDTO(@RequestBody @NotNull @Valid SkillDTO skillDTO) {
		return mapperFacade.map(softSkillService.updateSoftSkill(mapperFacade.map(skillDTO, SoftSkill.class)), SkillDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteSoftSkill(@PathVariable("id") Long id) {
		softSkillService.deleteSoftSkillById(id);
	}

}
