package com.devsuperior.desafioCrud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		
	}
	
	public ValidationError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String name, String message) {
		errors.add(new FieldMessage(name, message));
	}
}
