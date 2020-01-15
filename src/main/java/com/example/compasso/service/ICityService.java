package com.example.compasso.service;

import com.example.compasso.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {

    /**
     * Method to save the city
     * @param city
     * @return city
     */
    City insert (City city);

    /**
     * Method to find citys by name
     * @param name
     * @param pageable
     * @return Page<City>
     */
    Page<City> findByName(String name,Pageable pageable);

    /**
     * Method to find citys by state
     * @param state
     * @param pageable
     * @return Page<City>
     */
    Page<City> findByState(String state, Pageable pageable);
}
