package com.petclinic.model;

public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3816478822098828395L;
	
	private String firstName;
	private String lastName;
	
	
	
	public Person() {

	}
	
	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
