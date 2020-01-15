package com.example.compasso.repository;

import com.example.compasso.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {

    Page<City> findByName(String name, Pageable pageable);

    Page<City> findByState(String state, Pageable pageable);
}
