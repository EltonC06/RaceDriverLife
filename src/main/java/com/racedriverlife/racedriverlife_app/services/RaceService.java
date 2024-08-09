package com.racedriverlife.racedriverlife_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;
import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RaceService {
	
	@Autowired
	private RaceRepository repository;
	
	public List<Race> getAllRaces() {
		return this.repository.findAll();
	}
	
	public Race getRaceById(Long id) {
		Optional<Race> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	public Race save(Race race) {
		return this.repository.save(race);
	}
	

	
	public Race update(Long id, Race race) {
		try {
			Race entity = repository.getReferenceById(id);
			entity = updateData(entity, race);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		else {
			throw new DatabaseException("Resource not found. Id " + id);
		}
	}
		
	private Race updateData(Race entity, Race race) {
		entity.setDoneTasks(race.getDoneTasks());
		entity.setIsActive(race.getIsActive());
		entity.setTaskQuantity(race.getTaskQuantity());
		entity.countTotalTasks();
		return entity;
	}
	
	

}
