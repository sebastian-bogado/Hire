package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.exception.AreaExistException;
import io.nsu.hire.apitags.exception.AreaNotFoundException;
import io.nsu.hire.apitags.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {

	List<Area> getAreas();

	Optional<Area> getAreaById(Long id) throws AreaNotFoundException;

	Optional<Area> getAreaByUuid(String uuid) throws AreaNotFoundException;

	Area createArea(Area area);

	Area updateArea(Area area) throws AreaExistException;

	void deleteArea(Long id);

	void deleteArea(String uuid);

}
