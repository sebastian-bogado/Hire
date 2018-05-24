package io.nsu.hire.apitags.dao;

import io.nsu.hire.apitags.model.TechnicalSkill;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicalSkillDao extends BaseBeanDao<TechnicalSkill> {

	Optional<TechnicalSkill> findTechnicalSkillBySkillNameAndActiveTrue(String name);

}
