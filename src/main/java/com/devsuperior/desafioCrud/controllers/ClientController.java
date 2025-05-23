package com.devsuperior.desafioCrud.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.desafioCrud.dto.ClientDTO;
import com.devsuperior.desafioCrud.services.ClientService;

import jakarta.validation.Valid;

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
	
	@PutMapping(value = "/{id}")
	ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
		ClientDTO client = service.update(id, dto);
		return ResponseEntity.ok(client);
	}
	
	@PostMapping
	ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {
		ClientDTO client = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(client);
	}
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
