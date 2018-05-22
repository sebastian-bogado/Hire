package io.nsu.hire.apiclients.service.impl;

import io.nsu.hire.apiclients.dao.ClientDao;
import io.nsu.hire.apiclients.exception.ClientExistException;
import io.nsu.hire.apiclients.model.Client;
import io.nsu.hire.apiclients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl extends LogicalDeleteableBeanService<Client> implements ClientService {
	@Autowired
	private ClientDao clientDao;


	@Override
	public List<Client> readClients() {
		return clientDao.findAll();
	}

	@Override
	public Page<Client> readClients(Integer size, Integer page) {
		Pageable pageable = new QPageRequest(page, size);
		return clientDao.findAll(pageable);
	}

	@Override
	public Optional<Client> readClientById(Long id) {
		return clientDao.findById(id);
	}

	@Override
	public Client createClient(Client client) {
		if (clientDao.findAllByFiscalIdOrFiscalName(client.getFiscalId(), client.getFiscalName()).isEmpty()) {
			return clientDao.save(prepareToCreate(client));
		} else {
			throw new ClientExistException(client.getFiscalId());
		}
	}

	@Override
	public void deleteClient(Long id) {
		clientDao.deleteById(id);
	}

}
