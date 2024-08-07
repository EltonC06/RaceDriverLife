package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.services.RaceCentralService;

@RestController
@RequestMapping(value = "/racecentral")
public class RaceCentralController {
	
	@Autowired
	RaceCentralService service;
	
	@GetMapping
	public List<RaceCentral> findAll() {
		List<RaceCentral> result = service.getAllCentral();
		return result;
	}
	
	@GetMapping("/{id}")
	public RaceCentral getRaceCentral(@PathVariable(name = "id") Long id) {
		RaceCentral raceCentral = service.getCentralById(id);
		return raceCentral;
	}
	
	
	
}
