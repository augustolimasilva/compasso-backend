package com.example.compasso.service.impl;

import com.example.compasso.exception.CustomException;
import com.example.compasso.model.City;
import com.example.compasso.model.Client;
import com.example.compasso.repository.ICityRepository;
import com.example.compasso.repository.IClientRepository;
import com.example.compasso.service.IClientService;
import com.example.compasso.util.Constants;
import com.example.compasso.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;

    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public Client insert(Client client) {

        if(client.getCity().getId() == null){
            throw new CustomException(Constants.ID_CITY_REQUIRED);
        }

        Optional<City> city = iCityRepository.findById(client.getCity().getId());

        if(city.isPresent()) {
            return iClientRepository.save(client);
        }else{
            throw new CustomException(Constants.CITY_NOT_FOUND);
        }
    }

    @Override
    public Page<Client> findByName(String name, Pageable pageable) {
        return iClientRepository.findByName(name, pageable);
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
        Optional<Client> client = iClientRepository.findById(id);

        if(client.isPresent()){
            iClientRepository.deleteById(id);
            return new Response(Constants.SUCESS, Constants.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }

    @Override
    public Client alter(Client client, Long id) {

        Optional<Client> cli = iClientRepository.findById(id);

        if(cli.isPresent()){
            cli.get().setName(client.getName());
            return iClientRepository.save(cli.get());
        }else{
            throw new CustomException(Constants.CLIENT_NOT_FOUND);
        }
    }
}