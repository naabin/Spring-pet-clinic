package com.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "description")
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
