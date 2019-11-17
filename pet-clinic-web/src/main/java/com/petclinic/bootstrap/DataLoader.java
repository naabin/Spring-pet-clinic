package com.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService; 
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType("Dog");
		PetType savedDogPetType = this.petTypeService.save(dog);
		
		PetType cat = new PetType("Cat");
		PetType savedCatPetType = this.petTypeService.save(cat);
		
		
		
		Owner owner1 = new Owner("Michael", "Weston");

		Owner owner2 = new Owner("Fiona", "Glennane");

		this.ownerService.save(owner1);
		this.ownerService.save(owner2);

		Vet vet1 = new Vet("Sam", "Axe");
		Vet vet2 = new Vet("Nabin", "Karki");

		this.vetService.save(vet1);
		this.vetService.save(vet2);

		System.out.println("Loading Owners.... Vets...");

	}

}
