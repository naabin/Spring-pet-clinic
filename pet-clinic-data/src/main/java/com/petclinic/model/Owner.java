package com.petclinic.model;


import java.util.Set;

public class Owner extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6116274458963665495L;
	
	private Set<Pet> pets; 
	

	public Owner(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Owner() {
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
	

}
