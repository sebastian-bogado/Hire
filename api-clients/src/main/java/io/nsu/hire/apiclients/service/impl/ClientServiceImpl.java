package io.nsu.hire.apiclients.service.impl;

import io.nsu.hire.apiclients.dao.ClientDao;
import io.nsu.hire.apiclients.model.Client;
import io.nsu.hire.apiclients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;


    @Override
    public List<Client> readAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Page<Client> readAllClients(Integer size, Integer page) {
        Pageable pageable = new QPageRequest(page, size);
        return clientDao.findAll(pageable);
    }



}
