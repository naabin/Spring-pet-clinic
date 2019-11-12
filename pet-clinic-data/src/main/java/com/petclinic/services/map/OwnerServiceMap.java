package com.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long>  implements OwnerService{

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

	@Override
	public Set<Owner> findAll() {
		
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}



}