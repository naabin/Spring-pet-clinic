package com.petclinic.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "owners")
public class Owner extends Person {

	private static final long serialVersionUID = 6116274458963665495L;

	@Column(name = "pets")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "telephone")
	private String telephone;

	

}
