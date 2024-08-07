package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.services.RaceService;

@RestController
@RequestMapping(value = "/race")
public class RaceController {
	
	@Autowired
	RaceService service;
	
	@GetMapping
	public List<Race> findAll() {
		List<Race> result = service.getAllRaces();
		return result;
	}
	
	@GetMapping("/{id}")
	public Race getRace(@PathVariable(name = "id") Long id) {
		Race race = service.getRaceById(id);
		return race;
	}
	
}
