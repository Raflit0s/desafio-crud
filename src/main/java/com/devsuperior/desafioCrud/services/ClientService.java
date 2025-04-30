package com.devsuperior.desafioCrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafioCrud.dto.ClientDTO;
import com.devsuperior.desafioCrud.entities.Client;
import com.devsuperior.desafioCrud.repositories.ClientRepository;
import com.devsuperior.desafioCrud.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDTO(client);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable page) {
		Page<Client> client = repository.findAll(page);
		return client.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO client) {
		try{
		Client entity = repository.getReferenceById(id);
		dtoToEntity(client, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}
	
	public ClientDTO insert(ClientDTO client) {
		Client entity = new Client();
		dtoToEntity(client, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		repository.deleteById(id);
	}
	
	public void dtoToEntity(ClientDTO dto, Client entity) {
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setName(dto.getName());
	}
}
