package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.model.SoftSkill;

import java.util.List;
import java.util.Optional;

public interface SoftSkillService {

	List<SoftSkill> readAllSoftSkills();

	Optional<SoftSkill> readSoftSkillById(Long id);

	Optional<SoftSkill> readSoftSkillByUuid(String uuid);

	SoftSkill createSoftSkill(SoftSkill softSkill);

	SoftSkill updateSoftSkill(SoftSkill softSkill);

	void deleteSoftSkillById(Long id);

	void deleteSoftSkillByUuid(String uuid);


}
