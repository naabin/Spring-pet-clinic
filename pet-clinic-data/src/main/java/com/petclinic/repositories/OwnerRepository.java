package com.petclinic.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
	
	Set<Owner> findAllByLastNameLike(String name);
	
}
