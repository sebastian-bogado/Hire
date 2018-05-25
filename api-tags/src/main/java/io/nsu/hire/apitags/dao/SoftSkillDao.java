package io.nsu.hire.apitags.dao;

import io.nsu.hire.apitags.model.SoftSkill;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoftSkillDao extends BaseBeanDao<SoftSkill> {
	Optional<SoftSkill> findSoftSkillBySkillNameAndActiveTrue(String name);
}
