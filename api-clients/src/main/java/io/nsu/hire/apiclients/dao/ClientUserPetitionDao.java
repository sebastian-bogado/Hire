package io.nsu.hire.apiclients.dao;

import com.nsu.duhire.webapi.info.model.ClientUserPetition;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ClientUserPetitionDao extends BaseBeanDao<ClientUserPetition>{

	Optional<ClientUserPetition> findClientUserPetitionByUuidAndCreationDateIsGreaterThanEqual(String uuid, Date from);
	Optional<ClientUserPetition> findClientUserPetitionByEmailAndCreationDateIsGreaterThanEqual(String email, Date from);
	Optional<ClientUserPetition> findByEmail(String email);

}
