package com.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8052539265768885228L;

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	
	

	public Pet(PetType petType, Owner owner, LocalDate birthDate) {
		super();
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}
	
	public Pet() {
		
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
