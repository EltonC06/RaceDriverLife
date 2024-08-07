package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.repositories.RaceCentralRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RaceCentralService {
	
	@Autowired
	private RaceCentralRepository repository;
	
	public List<RaceCentral> getAllCentral() {
		return this.repository.findAll();
	}
	
	public RaceCentral getCentralById(Long id) {
		return this.repository.findById(id).get();
	}
	
	public RaceCentral save(RaceCentral raceCentral) {
		return this.repository.save(raceCentral);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public RaceCentral update(Long id, RaceCentral raceCentral) {
		RaceCentral entity = repository.getReferenceById(id);
		entity = updateData(entity, raceCentral);
		return repository.save(entity);
	}

	private RaceCentral updateData(RaceCentral entity, RaceCentral raceCentral) {
		entity.setRacesDisputed(raceCentral.getRacesDisputed());
		entity.setRacesWon(raceCentral.getRacesWon());
		return entity;
	}
	
	
	
}
