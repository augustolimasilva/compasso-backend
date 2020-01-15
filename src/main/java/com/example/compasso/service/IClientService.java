package com.example.compasso.service;

import com.example.compasso.model.Client;
import com.example.compasso.util.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {

    /**
     * Method to save a client
     * @param client
     * @return Client
     */
    Client insert(Client client);

    /**
     * Method to find clients by name
     * @param name
     * @param pageable
     * @return Page<Client>
     */
    Page<Client> findByName(String name, Pageable pageable);

    /**
     * Method to find a client by Id
     * @param id
     * @return
     */
    Client findById(Long id);

    /**
     * Method to delete a client by Id
     * @param id
     * @return Response
     */
    Response deleteById(Long id);

    /**
     * Method to alter name by client
     * @param client
     * @param id
     * @return Client
     */
    Client alter(Client client, Long id);
}
