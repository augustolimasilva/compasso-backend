package com.example.compasso.controller;

import com.example.compasso.model.Client;
import com.example.compasso.model.dto.ClientAlterDTO;
import com.example.compasso.model.dto.ClientDTO;
import com.example.compasso.service.IClientService;
import com.example.compasso.util.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody @Valid ClientDTO clientDTO){
        Client client = new ModelMapper().map(clientDTO, Client.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(iClientService.insert(client).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<Client>> findByName(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(iClientService.findByName(name, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return new ResponseEntity<>(iClientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id){
        return new ResponseEntity<>(iClientService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> alter(@RequestBody @Valid ClientAlterDTO clientAlterDTO, @PathVariable Long id){
        Client client = new ModelMapper().map(clientAlterDTO, Client.class);
        return new ResponseEntity<>(iClientService.alter(client, id), HttpStatus.OK);
    }
}