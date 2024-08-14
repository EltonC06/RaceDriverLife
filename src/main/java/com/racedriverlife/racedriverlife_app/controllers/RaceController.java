package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.DTOs.RaceDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.services.RaceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/races")
public class RaceController {

	@Autowired
	private RaceService service;

	@GetMapping
	public List<Race> findAll() {
		List<Race> result = service.getAllRaces();
		return result;
	}

	@GetMapping("/{id}")
	public Race findById(@PathVariable(name = "id") Long id) {
		Race race = service.getRaceById(id);
		return race;
	}

	@PutMapping("/{id}")
	public Race update(@PathVariable(name = "id") Long id, @Valid @RequestBody RaceDTO raceDTO) {
		return service.update(id, raceDTO);
	}
}
