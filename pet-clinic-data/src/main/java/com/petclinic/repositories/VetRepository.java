package com.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
