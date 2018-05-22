package io.nsu.hire.apiclients.service;

import io.nsu.hire.apiclients.model.Client;
import io.nsu.hire.apiclients.vo.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClientService {

	List<Client> readClients();

	Page<Client> readClients(Integer size, Integer page);

	Optional<Client> readClientById(Long id);

	Client createClient(Client client);

	void deleteClient(Long id);
}
