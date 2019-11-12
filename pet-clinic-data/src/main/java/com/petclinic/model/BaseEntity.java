package com.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8514031906777190798L;

	
	
	public BaseEntity(Long id) {
		this.id = id;
	}
	
	public BaseEntity() {
		
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
