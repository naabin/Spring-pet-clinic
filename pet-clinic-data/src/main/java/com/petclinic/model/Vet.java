package com.petclinic.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	private static final long serialVersionUID = 6390909902969305165L;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
				joinColumns = @JoinColumn(referencedColumnName = "vet_id"),
				inverseJoinColumns = @JoinColumn(referencedColumnName = "specialty_id"))
	private Set<Specialty> specialties = new HashSet<Specialty>();

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
