package com.devsuperior.desafioCrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafioCrud.dto.ClientDTO;
import com.devsuperior.desafioCrud.entities.Client;
import com.devsuperior.desafioCrud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	public ClientDTO findById(Long id) {
		Optional<Client> client = repository.findById(id);
		Client result = client.get();
		return new ClientDTO(result);
	}
	
	
}
