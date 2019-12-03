package com.petclinic.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity implements Serializable {


	private static final long serialVersionUID = 8514031906777190798L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	public boolean isNew() {
		return this.id == null;
	}
}
