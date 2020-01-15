package com.example.compasso.service;

import com.example.compasso.model.Client;
import com.example.compasso.util.Response;

public interface IClientService {

    Client insert(Client client);

    Client findByName(String name);

    Client findById(Long id);

    Response deleteById(Long id);

    Client alter(Client client);
}
