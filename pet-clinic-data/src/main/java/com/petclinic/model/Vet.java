package com.petclinic.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	private static final long serialVersionUID = 6390909902969305165L;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
				joinColumns = @JoinColumn(referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
	private Set<Specialty> specialties = new HashSet<Specialty>();
	


	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}
