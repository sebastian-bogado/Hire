package io.nsu.hire.apiclients.dao;

import io.nsu.hire.apiclients.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDao extends BaseBeanDao<Client> {

	Optional<Client> findClientByFiscalId(String fiscalId);

	Optional<Client> findClientByEmail(String email);
}
