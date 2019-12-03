package com.petclinic.services;

import java.util.Set;

import com.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	public Owner findByLastName(String lastName);
	
	Set<Owner> findAllByLastNameLike(String name);
	
}
