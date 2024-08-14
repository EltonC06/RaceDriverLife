package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.DTOs.RaceCentralDTO;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.services.RaceCentralService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/racecentrals")
public class RaceCentralController {
	
	@Autowired
	RaceCentralService service;
	
	@GetMapping
	public List<RaceCentral> findAll() {
		List<RaceCentral> result = service.getAllCentral();
		return result;
	}
	
	@GetMapping("/{id}")
	public RaceCentral findById(@PathVariable(name = "id") Long id) {
		RaceCentral raceCentral = service.getCentralById(id);
		return raceCentral;
	}
	
	@PutMapping("/{id}")
	public RaceCentral update(@PathVariable(name = "id") Long id) { // aqui pode atualilzar de duas maneiras.
		return service.autoUpdate(id);
	}
	
	@PutMapping("/manual/{id}") // manual update
	public RaceCentral manualUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody RaceCentralDTO raceCentralDTO) {
		return service.manualUpdate(id, raceCentralDTO);
	}
}
