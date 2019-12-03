package com.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long>  implements OwnerService{
	
	private final PetTypeMapService petTypeMapService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeMapService petTypeMapService, PetService petService) {
		
		this.petTypeMapService = petTypeMapService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(this.petTypeMapService.save(pet.getPetType()));
						}
					}
					else {
						throw new RuntimeException("Pet Type is required");
					}
					if(pet.getId() == null) {
						Pet savedPet = this.petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		}
		return null;
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll()
				.stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
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
		
	}@Override
	public Set<Owner> findAllByLastNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
