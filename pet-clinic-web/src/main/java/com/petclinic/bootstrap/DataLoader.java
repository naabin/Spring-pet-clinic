package com.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
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
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		
		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setName("Rascal");
		
		
		
		Owner owner1 = new Owner("Michael", "Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("121234532");
		owner1.getPets().add(mikesPet);

		Owner owner2 = new Owner("Fiona", "Glennane");
		owner2.setAddress("200 Manhattan ST");
		owner2.setCity("New York");
		owner2.setTelephone("1245345509");
		owner2.getPets().add(fionasPet);

		this.ownerService.save(owner1);
		this.ownerService.save(owner2);

		Vet vet1 = new Vet("Sam", "Axe");
		Vet vet2 = new Vet("Nabin", "Karki");

		this.vetService.save(vet1);
		this.vetService.save(vet2);

		System.out.println("Loading Owners.... Vets...");

	}

}
