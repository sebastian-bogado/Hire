package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.model.TechnicalSkill;

import java.util.List;
import java.util.Optional;

public interface TechnicalSkillService {

	List<TechnicalSkill> readAllTechSkills();

	Optional<TechnicalSkill> readTechnicalSkillById(Long id);

	Optional<TechnicalSkill> readTechnicalSkillByUuid(String uuid);

	TechnicalSkill createTechnicalSkill(TechnicalSkill TechnicalSkill);

	TechnicalSkill updateTechnicalSkill(TechnicalSkill TechnicalSkill);

	void deleteTechnicalSkillById(Long id);

	void deleteTechnicalSkillByUuid(String uuid);


}
