package com.example.compasso.service.impl;

import com.example.compasso.exception.CustomException;
import com.example.compasso.model.City;
import com.example.compasso.model.Client;
import com.example.compasso.repository.IClientRepository;
import com.example.compasso.service.IClientService;
import com.example.compasso.util.Constants;
import com.example.compasso.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;

    @Override
    public Client insert(Client client) {
        return iClientRepository.save(client);
    }

    @Override
    public Client findByName(String name) {
        Optional<Client> client = Optional.ofNullable(iClientRepository.findByName(name));

        if(client.isPresent()){
            return client.get();
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = iClientRepository.findById(id);

        if(client.isPresent()){
            return client.get();
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }

    @Override
    public Response deleteById(Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constants.ID_REQUIRED);
        }

        Optional<Client> client = iClientRepository.findById(id);

        if(client.isPresent()){
            iClientRepository.deleteById(id);
            return new Response("sucesso", Constants.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }

    @Override
    public Client alter(Client client, Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constants.ID_REQUIRED);
        }

        Optional<Client> cli = iClientRepository.findById(id);

        if(cli.isPresent()){
            client.setId(id);
            return iClientRepository.save(client);
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }
}
