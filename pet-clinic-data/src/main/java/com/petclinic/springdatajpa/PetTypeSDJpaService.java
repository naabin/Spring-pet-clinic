package com.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.PetType;
import com.petclinic.repositories.PetTypeRepository;
import com.petclinic.services.PetTypeService;

@Service
@Profile(value = "springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		this.petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return this.petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return this.petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		this.petTypeRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		this.petTypeRepository.deleteById(id);

	}

}
