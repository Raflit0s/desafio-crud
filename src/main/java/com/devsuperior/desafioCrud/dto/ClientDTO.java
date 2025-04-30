package com.devsuperior.desafioCrud.dto;

import java.time.LocalDate;

import com.devsuperior.desafioCrud.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class ClientDTO {
	private Long id;
	
	@NotBlank(message = "Nome não pode ser vazio")
	private String name;
	private String cpf;
	private Double income;
	@PastOrPresent(message = "data de nascimento não pode ser futura")
	private LocalDate birthDate;
	private Integer children;

	public ClientDTO() {
	}
	
	public ClientDTO(Client client) {
		id = client.getId();
		name = client.getName();
		cpf = client.getCpf();
		income = client.getIncome();
		birthDate = client.getBirthDate();
		children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}
	
	
}
