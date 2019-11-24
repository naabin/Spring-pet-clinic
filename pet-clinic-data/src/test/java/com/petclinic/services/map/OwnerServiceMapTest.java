package com.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerMapService;
	
	private final Long ownerId = 1L;

	@BeforeEach
	void setUp() throws Exception {
		this.ownerMapService = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		Owner owner = new Owner();
		owner.setId(this.ownerId);
		owner.setLastName("smith");
		
		this.ownerMapService.save(owner);
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdID() {
		Owner owner = this.ownerMapService.findById(this.ownerId);
		assertEquals(this.ownerId, owner.getId());
	}

	@Test
	void testSaveT() {
		Owner owner2 = new Owner();
		owner2.setId(2L);
		Owner owner = this.ownerMapService.save(owner2);
		assertEquals(2L, owner.getId());
	}
	
	@Test
	void testSaveWithoutId() {
		Owner o = new Owner();
		Owner owner = this.ownerMapService.save(o);
		assertNotNull(owner);
		assertNotNull(owner.getId());
		
	}

	@Test
	void testDeleteByIdID() {
		Owner owner = this.ownerMapService.findById(this.ownerId);
		this.ownerMapService.deleteById(owner.getId());
		
		assertEquals(0, this.ownerMapService.findAll().size());
	}

	@Test
	void testDeleteT() {
		Owner owner = this.ownerMapService.findById(this.ownerId);
		this.ownerMapService.delete(owner);
		assertEquals(0, this.ownerMapService.findAll().size());
	}
	
	@Test
	void testFindByLastName() {
		Owner name = this.ownerMapService.findByLastName("smith");
		
		assertNotNull(name);
		
		assertEquals(this.ownerId, name.getId());
	}
	
	@Test
	void testNotfoundByLastName() {
		Owner byLastName = this.ownerMapService.findByLastName("nabin");
		assertNull(byLastName);
		
	}

}
