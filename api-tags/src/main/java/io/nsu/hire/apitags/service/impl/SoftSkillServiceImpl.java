package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.dao.SoftSkillDao;
import io.nsu.hire.apitags.exception.SoftSkillExistException;
import io.nsu.hire.apitags.exception.SoftSkillNotFoundException;
import io.nsu.hire.apitags.model.SoftSkill;
import io.nsu.hire.apitags.service.SoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftSkillServiceImpl extends LogicalDeleteableBeanService<SoftSkill> implements SoftSkillService {

	@Autowired
	private SoftSkillDao softSkillDao;

	@Override
	public List<SoftSkill> readAllSoftSkills() {
		return softSkillDao.findAll();
	}

	@Override
	public Optional<SoftSkill> readSoftSkillById(Long id) {
		return softSkillDao.findById(id);
	}

	@Override
	public Optional<SoftSkill> readSoftSkillByUuid(String uuid) {
		return softSkillDao.findByUuid(uuid);
	}

	@Override
	public SoftSkill createSoftSkill(SoftSkill softSkill) {
		if (softSkillDao.findSoftSkillBySkillNameAndActiveTrue(softSkill.getSkillName()).isPresent()) {
			throw new SoftSkillExistException(softSkill.getSkillName());
		}
		return softSkillDao.save(prepareToCreate(softSkill));
	}

	@Override
	public SoftSkill updateSoftSkill(SoftSkill softSkill) {
		Optional<SoftSkill> softSkillOptional = softSkillDao.findSoftSkillBySkillNameAndActiveTrue(softSkill.getSkillName());
		if (softSkillOptional.isPresent() && !softSkillOptional.get().getId().equals(softSkill.getId())) {
			throw new SoftSkillExistException(softSkill.getSkillName());
		}
		return softSkillDao.save(prepareToUpdate(softSkill));
	}

	@Override
	protected SoftSkill prepareToUpdate(SoftSkill softSkill) {
		SoftSkill persistedElement = readSoftSkillById(softSkill.getId()).orElseThrow(() -> new SoftSkillNotFoundException(softSkill.getId().toString()));
		persistedElement.setSkillName(softSkill.getSkillName());
		persistedElement.setDescription(softSkill.getDescription());
		return super.prepareToUpdate(persistedElement);
	}

	@Override
	public void deleteSoftSkillById(Long id) {
		softSkillDao.deleteById(id);
	}

	@Override
	public void deleteSoftSkillByUuid(String uuid) {
		softSkillDao.deleteByUuid(uuid);
	}
}
