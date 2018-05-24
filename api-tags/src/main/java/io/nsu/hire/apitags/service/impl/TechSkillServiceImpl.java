package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.dao.TechnicalSkillDao;
import io.nsu.hire.apitags.exception.TechSkillExistException;
import io.nsu.hire.apitags.exception.TechSkillNotFoundException;
import io.nsu.hire.apitags.model.TechnicalSkill;
import io.nsu.hire.apitags.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechSkillServiceImpl extends BaseBeanService<TechnicalSkill> implements TechnicalSkillService {

	@Autowired
	private TechnicalSkillDao techSkillDao;

	@Override
	public List<TechnicalSkill> readAllTechSkills() {
		return techSkillDao.findAll();
	}

	public Optional<TechnicalSkill> readTechnicalSkillById(Long id) {
		return techSkillDao.findById(id);
	}

	public Optional<TechnicalSkill> readTechnicalSkillByUuid(String uuid) {
		return techSkillDao.findByUuid(uuid);
	}

	@Override
	public TechnicalSkill createTechnicalSkill(TechnicalSkill technicalSkill) throws TechSkillExistException {
		if (techSkillDao.findTechnicalSkillBySkillNameAndActiveTrue(technicalSkill.getSkillName()).isPresent()) {
			throw new TechSkillExistException(technicalSkill.getSkillName());
		}
		return techSkillDao.save(prepareToCreate(technicalSkill));
	}

	@Override
	public TechnicalSkill updateTechnicalSkill(TechnicalSkill technicalSkill) {
		Optional<TechnicalSkill> technicalSkillOptional = techSkillDao.findTechnicalSkillBySkillNameAndActiveTrue(technicalSkill.getSkillName());
		if (technicalSkillOptional.isPresent() && !technicalSkillOptional.get().getId().equals(technicalSkill.getId())) {
			throw new TechSkillExistException(technicalSkill.getSkillName());
		}
		return techSkillDao.save(prepareToUpdate(technicalSkill));
	}

	@Override
	protected TechnicalSkill prepareToUpdate(TechnicalSkill technicalSkill) {
		TechnicalSkill persistedElement = readTechnicalSkillById(technicalSkill.getId()).orElseThrow(() -> new TechSkillNotFoundException(technicalSkill.getId().toString()));
		persistedElement.setSkillName(technicalSkill.getSkillName());
		persistedElement.setDescription(technicalSkill.getDescription());
		return super.prepareToUpdate(persistedElement);
	}

	@Override
	public void deleteTechnicalSkillById(Long id) {
		techSkillDao.deleteById(id);
	}

	@Override
	public void deleteTechnicalSkillByUuid(String uuid) {
		techSkillDao.deleteByUuid(uuid);
	}
}
