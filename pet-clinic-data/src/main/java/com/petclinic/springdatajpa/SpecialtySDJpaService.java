package com.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Specialty;
import com.petclinic.repositories.SpecialtyRepository;
import com.petclinic.services.SpecialtyService;

@Service
@Profile(value = "springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {
	
	private final SpecialtyRepository specialtyRepository;
	

	public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<Specialty>();
		this.specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		return this.specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) { 
		return this.specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		this.specialtyRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		this.specialtyRepository.deleteById(id);		
	}

}
