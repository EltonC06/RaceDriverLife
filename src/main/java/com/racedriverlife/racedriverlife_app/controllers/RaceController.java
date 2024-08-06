package com.racedriverlife.racedriverlife_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.services.RaceService;

@Controller
public class RaceController {
	
	@Autowired
	RaceService raceService;
	
	@GetMapping("/race/{id}")
	@ResponseBody
	public Race getRace(@PathVariable(name = "id") Long id) {
		Race race = raceService.getRaceById(id);
		return race;
	}
	
}
