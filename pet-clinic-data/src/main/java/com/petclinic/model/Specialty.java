package com.petclinic.model;

public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	

	public Specialty(String description) {
		super();
		this.description = description;
	}
	
	public Specialty() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	

}
