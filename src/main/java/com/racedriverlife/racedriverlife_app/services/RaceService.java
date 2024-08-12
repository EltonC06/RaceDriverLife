package com.racedriverlife.racedriverlife_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.RaceDTO;
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
		List<Race> raceList = this.repository.findAll();

		return raceList;
		
	}
	
	private RaceDTO convertToDTO(Race rc) {
		RaceDTO raceDTO = new RaceDTO();
		
		raceDTO.setActive(rc.getIsActive());
		raceDTO.setDoneTasks(rc.getDoneTasks());
		raceDTO.setTaskQuantity(rc.getTaskQuantity());
		
		return raceDTO;
	}

	public Race getRaceById(Long id) {
		Optional<Race> obj = repository.findById(id);
		
		obj.orElseThrow( () -> new ResourceNotFoundException(id) );
		
		Race race = obj.get();
		
		return race;
	}
	
	public Race save(Race race) {
		return this.repository.save(race);
	}
	

	
	public Race update(Long id, RaceDTO raceDTO) {
		try {
			Race entity = repository.getReferenceById(id); // corrida que vai mudar
			
			Race race = convertDTOtoEntity(raceDTO);   // corrida ja alterada qu vai substituir a outras
			
			entity = updateData(entity, race);
			
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private Race convertDTOtoEntity(RaceDTO raceDTO) {
		Race race = new Race();
		
		race.setDoneTasks(raceDTO.getDoneTasks());
		race.setTaskQuantity(raceDTO.getTaskQuantity());
		race.setIsActive(raceDTO.isActive());
		
		return race;
	}
	
	protected RaceDTO convertEntitytoDTO(Race race) {
		RaceDTO raceDTO = new RaceDTO();
		
		raceDTO.setActive(race.getIsActive());
		raceDTO.setDoneTasks(race.getDoneTasks());
		raceDTO.setTaskQuantity(race.getTaskQuantity());
		
		return raceDTO;
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
	
	protected boolean isFinished(Long id) {
		Race race = repository.findById(id).get();
		
		if (race.getDoneTasks().equals(race.getTaskQuantity())) {		
			return true;
		} else {
			return false;
		}
	}
}
