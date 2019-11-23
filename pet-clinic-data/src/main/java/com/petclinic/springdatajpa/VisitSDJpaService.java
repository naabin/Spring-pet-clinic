package com.petclinic.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Visit;
import com.petclinic.repositories.VisitRepository;
import com.petclinic.services.VisitService;


@Service
@Profile(value = "springdatajpa")
public class VisitSDJpaService implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		this.visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return this.visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		if(object != null) {
			return this.visitRepository.save(object);
		}
		return null;
	}

	@Override
	public void delete(Visit object) {
		this.visitRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		this.visitRepository.findById(id);
	}

}
