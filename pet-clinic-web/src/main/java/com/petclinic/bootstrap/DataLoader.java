package com.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.VetService;
import com.petclinic.services.map.OwnerServiceMap;
import com.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner(1L, "Michael", "Weston");
		
		Owner owner2 = new Owner(2L, "Fiona", "Glennane");
		
		this.ownerService.save(owner1);
		this.ownerService.save(owner2);
		
		Vet vet1 = new Vet(1L, "Sam", "Axe");
		Vet vet2 = new Vet(2L, "Nabin", "Karki");
		
		this.vetService.save(vet1);
		this.vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		
	}

}
