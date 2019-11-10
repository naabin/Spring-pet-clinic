package com.petclinic.services;

import java.util.Set;

import com.petclinic.model.Vet;

public interface VetService {
	
	public Vet findById(Long id);
	
	public Vet save(Vet vet);
	
	public Set<Vet> findAll();

}
