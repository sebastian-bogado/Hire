package io.nsu.hire.apiclients.service;

import io.nsu.hire.apiclients.model.Client;
import io.nsu.hire.apiclients.vo.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {

    List<Client> readAllClients();
    Page<Client> readAllClients(Integer size, Integer page);
    Client createClient(Client client, UserVO userVO);

}
