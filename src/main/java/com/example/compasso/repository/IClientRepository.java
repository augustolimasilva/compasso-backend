package com.example.compasso.repository;

import com.example.compasso.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByName(String name, Pageable pageable);
}
