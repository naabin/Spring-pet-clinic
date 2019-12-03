package com.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.repositories.OwnerRepository;
import com.petclinic.services.OwnerService;

@Service
@Profile(value = "springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;


	public OwnerSDJpaService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;

	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<Owner>();
		this.ownerRepository.findAll().forEach(owners :: add);;
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		Optional<Owner> optionalOwner = this.ownerRepository.findById(id);
		return optionalOwner.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		Owner savedOwner = this.ownerRepository.save(object);
		return savedOwner;
	}

	@Override
	public void delete(Owner object) {
		this.ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerRepository.findByLastName(lastName);
	}

	@Override
	public Set<Owner> findAllByLastNameLike(String name) {
		return this.ownerRepository.findAllByLastNameLike(name);
	}

}
