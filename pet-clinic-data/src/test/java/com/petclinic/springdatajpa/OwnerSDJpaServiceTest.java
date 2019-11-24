package com.petclinic.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.petclinic.model.Owner;
import com.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	private static final String LAST_NAME = "smith";

	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerSDJpaService ownerService;
	
	Owner owner;
	

	@BeforeEach
	void setUp() throws Exception {
		
		owner = new Owner();
		owner.setId(1L);
		owner.setLastName(LAST_NAME);
	}


	@Test
	void testFindAll() {
		Set<Owner> owners = new HashSet<Owner>();
		for(long i = 0; i < 3; i++) {
			Owner owner = new Owner();
			owner.setId(i);
			owners.add(owner);
		}
		
		when(this.ownerRepository.findAll()).thenReturn(owners);
		Set<Owner> savedOwners = this.ownerService.findAll();
		
		assertNotNull(savedOwners);
		assertEquals(3, savedOwners.size());
	}

	@Test
	void testFindById() {
		when(this.ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(owner));
		
		Owner byId = this.ownerService.findById(this.owner.getId());
		
		assertEquals(1L, byId.getId());
		assertNotNull(byId);
		
	}
	
	@Test
	void findByIdNotFound() {
		when(this.ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		Owner savedOwner = this.ownerService.findById(1L);
		assertNull(savedOwner);
	}
	

	@Test
	void testSave() {
		
		Owner owner = new Owner();
		owner.setId(1L);
		when(this.ownerRepository.save(Mockito.any())).thenReturn(owner);
		
		Owner savedOwner = this.ownerService.save(owner);
		
		assertNotNull(savedOwner);
		
		assertEquals(1L, savedOwner.getId());
		
		verify(this.ownerRepository).save(Mockito.any());
		
	}

	@Test
	void testDelete() {
		
		this.ownerService.delete(owner);
		
		verify(this.ownerRepository).delete(Mockito.any());
		
	}

	@Test
	void testDeleteById() {
		
		this.ownerService.deleteById(this.owner.getId());
		verify(this.ownerRepository, times(1)).deleteById(Mockito.anyLong());
	}

	@Test
	void testFindByLastName() {
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setLastName(LAST_NAME);
		
		when(this.ownerRepository.findByLastName(Mockito.any())).thenReturn(owner);
		
		Owner lastName = this.ownerService.findByLastName(LAST_NAME);
		
		assertNotNull(lastName);
		assertEquals(LAST_NAME, lastName.getLastName());
		
		verify(this.ownerRepository).findByLastName(Mockito.any());
	}

}
