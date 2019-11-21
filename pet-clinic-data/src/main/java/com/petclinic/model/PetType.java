package com.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916642135872925284L;
	@Column(name = "name")
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
