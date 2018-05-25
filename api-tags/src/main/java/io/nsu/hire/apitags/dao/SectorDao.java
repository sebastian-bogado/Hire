package io.nsu.hire.apitags.dao;

import io.nsu.hire.apitags.model.Sector;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorDao extends LogicalDeleteableBeanDao<Sector> {

	Optional<Sector> findByName(String name);

}
