package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;

@Service
public class RaceService {
	
	@Autowired
	RaceRepository raceRepository;
	
	public List<Race> getAllRaces() {
		return this.raceRepository.findAll();
	}
	
	public Race getRaceById(Long id) {
		return this.raceRepository.findById(id).get();
	}

}
