package com.petclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "types")
public class PetType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916642135872925284L;
	@Column(name = "name")
	private String name;
	
	public String toString() {
		return name;
	}
	
	 
}
