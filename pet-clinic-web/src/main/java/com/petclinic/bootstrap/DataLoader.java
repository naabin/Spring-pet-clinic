package com.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Specialty;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.SpecialtyService;
import com.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService; 
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = this.petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
		
	}

	private void loadData() {
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
		
		Specialty radiology = new Specialty("Radiology");
		Specialty surgery = new Specialty("Surgery");
		Specialty dentistry = new Specialty("Dentistry");
		
		Specialty savedRadiology = this.specialtyService.save(radiology);
		Specialty savedSurgery = this.specialtyService.save(surgery);
		Specialty savedDentistry = this.specialtyService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("121234532");
		owner1.getPets().add(mikesPet);
		

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");
		owner2.setAddress("200 Manhattan ST");
		owner2.setCity("New York");
		owner2.setTelephone("1245345509");
		owner2.getPets().add(fionasPet);

		this.ownerService.save(owner1);
		this.ownerService.save(owner2);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		Vet vet2 = new Vet();
		vet2.setFirstName("Nabin");
		vet2.setLastName("Karki");
		
		vet1.getSpecialties().add(savedRadiology);
		vet2.getSpecialties().add(savedSurgery);
		vet2.getSpecialties().add(savedDentistry);

		this.vetService.save(vet1);
		this.vetService.save(vet2);

		System.out.println("Loading Owners.... Vets...");
	}

}
