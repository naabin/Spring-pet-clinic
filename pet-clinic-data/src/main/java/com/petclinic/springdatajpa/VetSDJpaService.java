package com.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Vet;
import com.petclinic.repositories.VetRepository;
import com.petclinic.services.VetService;

@Service
@Profile(value = "springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		this.vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {

		return this.vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return this.vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		this.vetRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		this.vetRepository.deleteById(id);
	}

}
