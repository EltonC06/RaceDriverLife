package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;

import jakarta.transaction.Transactional;

@Service
public class RaceService {
	
	@Autowired
	private RaceRepository repository;
	
	public List<Race> getAllRaces() {
		return this.repository.findAll();
	}
	
	public Race getRaceById(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Race save(Race race) {
		return this.repository.save(race);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Race update(Long id, Race race) {
		Race entity = repository.getReferenceById(id);
		entity = updateData(entity, race);
		return repository.save(entity);
	}
		
	private Race updateData(Race entity, Race race) {
		entity.setDoneTasks(race.getDoneTasks());
		entity.setIsActive(race.getIsActive());
		entity.setTaskQuantity(race.getTaskQuantity());
		entity.countTotalTasks();
		return entity;
	}
	
	

}
