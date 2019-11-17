package com.petclinic.model;

import java.util.Set;

public class Vet extends Person {
	
	private static final long serialVersionUID = 6390909902969305165L;
	
	private Set<Specialty> specialties;

	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Vet() {
		
	}

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}
