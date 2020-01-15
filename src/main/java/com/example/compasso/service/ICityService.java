package com.example.compasso.service;

import com.example.compasso.model.City;

public interface ICityService {

    City insert (City city);

    City findByName(String name);

    City findByState(String state);
}
