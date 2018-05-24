package io.nsu.hire.apitags.dao;

import io.nsu.hire.apitags.model.Area;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaDao extends LogicalDeleteableBeanDao<Area> {

	Optional<Area> findByName(String name);

}
