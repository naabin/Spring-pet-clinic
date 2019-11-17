package com.petclinic.model;

public class PetType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916642135872925284L;
	private String name;
	
	public PetType(String name) {
		super();
		this.name = name;
	}
	
	public PetType() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 
}
