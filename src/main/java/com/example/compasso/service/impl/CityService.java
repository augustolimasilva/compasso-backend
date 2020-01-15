package com.example.compasso.service.impl;

import com.example.compasso.exception.CustomException;
import com.example.compasso.model.City;
import com.example.compasso.repository.ICityRepository;
import com.example.compasso.service.ICityService;
import com.example.compasso.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public City insert(City city) {
        return iCityRepository.save(city);
    }

    @Override
    public City findByName(String name) {
        Optional<City> city = Optional.ofNullable(iCityRepository.findByName(name));

        if(city.isPresent()){
          return city.get();
        }else{
            throw new CustomException(Constants.CITY_NOT_FOUND);
        }
    }

    @Override
    public City findByState(String state) {
        Optional<City> city = Optional.ofNullable(iCityRepository.findByState(state));

        if(city.isPresent()){
            return city.get();
        }else{
            throw new CustomException(Constants.CITY_NOT_FOUND);
        }
    }
}
