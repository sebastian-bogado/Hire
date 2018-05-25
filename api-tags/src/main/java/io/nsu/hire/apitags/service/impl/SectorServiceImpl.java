package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.dao.SectorDao;
import io.nsu.hire.apitags.exception.AreaExistException;
import io.nsu.hire.apitags.exception.BadFormatAreaException;
import io.nsu.hire.apitags.exception.SectorNotFoundException;
import io.nsu.hire.apitags.model.Sector;
import io.nsu.hire.apitags.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl extends LogicalDeleteableBeanService<Sector> implements SectorService {

	@Autowired
	private SectorDao sectorDao;

	@Override
	public List<Sector> getSectors() {
		return sectorDao.findAll();
	}

	@Override
	public Optional<Sector> getSectorById(Long id) {
		return sectorDao.findById(id);
	}

	@Override
	public Optional<Sector> getSectorByUuid(String uuid) {
		return sectorDao.findByUuid(uuid);
	}

	@Override
	public Sector createSector(Sector sector) {
		return sectorDao.save(this.prepareToCreate(sector));
	}

	@Override
	public Sector updateSector(Sector sec) {
		Optional<Sector> optionalSector = sectorDao.findByName(sec.getName());
		if (optionalSector.isPresent() && !optionalSector.get().getId().equals(sec.getId())) {
			throw new AreaExistException(sec.getName());
		}
		return sectorDao.save(this.prepareToUpdate(sec));
	}

	@Override
	public void deleteSector(Long id) {
		sectorDao.deleteById(id);
	}

	@Override
	public void deleteSector(String uuid) {
		sectorDao.deleteByUuid(uuid);
	}

	@Override
	protected Sector prepareToUpdate(Sector sector) {
		if (sector.getId() == null) {
			throw new BadFormatAreaException();
		}
		Sector persistedSector = this.getSectorById(sector.getId()).orElseThrow(() -> new SectorNotFoundException(sector.getId().toString()));
		persistedSector.setDescription(sector.getDescription());
		persistedSector.setName(persistedSector.getName());
		return super.prepareToUpdate(persistedSector);
	}

}
