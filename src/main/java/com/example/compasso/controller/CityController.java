package com.example.compasso.controller;

import com.example.compasso.model.City;
import com.example.compasso.model.dto.CityDTO;
import com.example.compasso.service.ICityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService iCityService;

    @PostMapping
    public ResponseEntity<City> insert(@RequestBody @Valid CityDTO cityDTO){
        City city = new ModelMapper().map(cityDTO, City.class);
        return new ResponseEntity<>(iCityService.insert(city), HttpStatus.CREATED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<City>> findByName(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(iCityService.findByName(name, pageable), HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<Page<City>> findByState(@PathVariable String state, Pageable pageable){
        return new ResponseEntity<>(iCityService.findByState(state, pageable), HttpStatus.OK);
    }
}