package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.dao.AreaDao;
import io.nsu.hire.apitags.exception.AreaExistException;
import io.nsu.hire.apitags.exception.AreaNotFoundException;
import io.nsu.hire.apitags.exception.BadFormatAreaException;
import io.nsu.hire.apitags.model.Area;
import io.nsu.hire.apitags.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl extends LogicalDeleteableBeanService<Area> implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreas() {
		return areaDao.findAll();
	}

	@Override
	public Optional<Area> getAreaById(Long id) throws AreaNotFoundException {
		return areaDao.findById(id);
	}

	@Override
	public Optional<Area> getAreaByUuid(String uuid) throws AreaNotFoundException {
		return areaDao.findByUuid(uuid);
	}

	@Override
	public Area createArea(Area area) {
		return areaDao.save(this.prepareToCreate(area));
	}

	@Override
	public Area updateArea(Area area) {
		Optional<Area> optionalArea = areaDao.findByName(area.getName());
		if (optionalArea.isPresent() && !optionalArea.get().getId().equals(area.getId())) {
			throw new AreaExistException(area.getName());
		}
		return areaDao.save(this.prepareToUpdate(area));
	}

	@Override
	public void deleteArea(Long id) {
		areaDao.deleteById(id);
	}

	@Override
	public void deleteArea(String uuid) {
		areaDao.deleteByUuid(uuid);
	}

	@Override
	protected Area prepareToUpdate(Area area) {
		if (area.getId() == null) {
			throw new BadFormatAreaException();
		}
		Area persistedArea = this.getAreaById(area.getId()).orElseThrow(() -> new AreaNotFoundException(area.getId().toString()));
		persistedArea.setDescription(area.getDescription());
		persistedArea.setName(persistedArea.getName());
		return super.prepareToUpdate(persistedArea);
	}

}
