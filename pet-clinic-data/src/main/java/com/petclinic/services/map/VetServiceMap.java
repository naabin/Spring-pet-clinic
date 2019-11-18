package com.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.petclinic.model.Specialty;
import com.petclinic.model.Vet;
import com.petclinic.services.SpecialtyService;
import com.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {

		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if (object.getSpecialties().size() > 0) {
			object.getSpecialties().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty savedSpecialty = this.specialtyService.save(specialty);
					
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
