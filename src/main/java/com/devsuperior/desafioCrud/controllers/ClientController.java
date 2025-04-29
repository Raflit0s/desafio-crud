package com.devsuperior.desafioCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.desafioCrud.dto.ClientDTO;
import com.devsuperior.desafioCrud.services.ClientService;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	ClientService service;
	
	@GetMapping(value = "/{id}")
	ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO client = service.findById(id);
		return ResponseEntity.ok(client);
	}
	
	@GetMapping
	ResponseEntity<Page<ClientDTO>> findAll(Pageable page) {
		Page<ClientDTO> client = service.findAll(page);
		return ResponseEntity.ok(client);
	}
}
