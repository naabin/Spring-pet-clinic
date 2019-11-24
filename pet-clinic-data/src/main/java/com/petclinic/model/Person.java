package com.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3816478822098828395L;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	
	
	public Person() {

	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
}
