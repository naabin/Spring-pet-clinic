package com.petclinic.services;

import com.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	public Owner findByLastName(String lastName);
	
}
