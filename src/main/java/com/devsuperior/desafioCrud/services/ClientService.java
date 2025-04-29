package com.devsuperior.desafioCrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafioCrud.dto.ClientDTO;
import com.devsuperior.desafioCrud.entities.Client;
import com.devsuperior.desafioCrud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> client = repository.findById(id);
		Client result = client.get();
		return new ClientDTO(result);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable page) {
		Page<Client> client = repository.findAll(page);
		return client.map(x -> new ClientDTO(x));
	}
}
