package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.exception.SectorExistException;
import io.nsu.hire.apitags.exception.SectorNotFoundException;
import io.nsu.hire.apitags.model.Sector;

import java.util.List;
import java.util.Optional;

public interface SectorService {

	List<Sector> getSectors();

	Optional<Sector> getSectorById(Long id) throws SectorNotFoundException;

	Optional<Sector> getSectorByUuid(String uuid) throws SectorNotFoundException;

	Sector createSector(Sector sector);

	Sector updateSector(Sector sector) throws SectorExistException;

	void deleteSector(Long id);

	void deleteSector(String uuid);

}
