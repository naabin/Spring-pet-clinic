package com.petclinic.services;

import java.util.Set;

import com.petclinic.model.Pet;

public interface PetService {
	
	public Pet findById(Long id);
	
	public Pet save(Pet pet);
	
	public Set<Pet> findAll();

}
