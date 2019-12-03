package com.petclinic.controllers;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;
import com.petclinic.controllers.OwnerController;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	
	
	@InjectMocks
	OwnerController controller;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	

	@BeforeEach
	void setUp() throws Exception {
		
		this.owners = new HashSet<Owner>();
		for(long i = 0; i < 3; i++) {
			Owner o = new Owner();
			o.setId(i);
			this.owners.add(o);
		}
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}


//	@Test
//	void testListOwners() throws Exception {
//		when(this.ownerService.findAll()).thenReturn(owners);
//		this.mockMvc.perform(get("/owners"))
//			.andExpect(status().is(200))
//			.andExpect(view().name("owners/findOwners"))
//			.andExpect(model().attribute("owners", Matchers.hasSize(3)));
//	}

	@Test
	void testFindOwners() throws Exception {
		this.mockMvc.perform(get("/owners/find"))
		.andExpect(status().is(200))
		.andExpect(view().name("owners/findOwners"))
		.andExpect(model().attributeExists("owner"));
		
		
	}
	
	@Test
	void testProcessFindForm() throws Exception{
		
		
		when(ownerService.findAllByLastNameLike(Mockito.any())).thenReturn(owners);
		
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/ownersList"))
			.andExpect(model().attribute("selections", Matchers.hasSize(3)));
	}
	
	
	@Test
	void testProcessFindFormReturnOne() throws Exception{
		Owner owner = new Owner();
		owner.setId(1L);
		Set<Owner> ownersSet = new HashSet<Owner>();
		ownersSet.add(owner);
		when(ownerService.findAllByLastNameLike(Mockito.any())).thenReturn(ownersSet);
		
		mockMvc.perform(get("/owners"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"));
		
	}
	
	@Test
	void initCreationForm() throws Exception {
		this.mockMvc.perform(get("/owners/new"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/createOrUpdateOwnerForm"))
			.andExpect(model().attributeExists("owner"));
		
		verifyNoMoreInteractions(this.ownerService);
	}
	
	@Test
	void testProcessCreationForm() throws Exception {
		Owner owner = new Owner();
		owner.setId(1L);
		when(this.ownerService.save(Mockito.any())).thenReturn(owner);
		this.mockMvc.perform(post("/owners/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));
		
		verify(this.ownerService).save(Mockito.any());
	}
	
	@Test
	void testInitUpdateOwnerform() throws Exception {
		Owner owner = new Owner();
		owner.setId(1L);
		when(this.ownerService.findById(Mockito.anyLong())).thenReturn(owner);
		
		this.mockMvc.perform(get("/owners/1/edit"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/createOrUpdateOwnerForm"))
			.andExpect(model().attributeExists("owner"));
	}
	
	
	

}
