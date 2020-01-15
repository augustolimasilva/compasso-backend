package com.example.compasso.service.impl;

import com.example.compasso.model.City;
import com.example.compasso.repository.ICityRepository;
import com.example.compasso.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public City insert(City city) {
        return iCityRepository.save(city);
    }

    @Override
    public Page<City> findByName(String name, Pageable pageable) {
        return iCityRepository.findByName(name, pageable);
    }

    @Override
    public Page<City> findByState(String state, Pageable pageable) {
        return iCityRepository.findByState(state, pageable);
    }
}