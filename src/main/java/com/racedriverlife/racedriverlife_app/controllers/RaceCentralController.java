package com.racedriverlife.racedriverlife_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.services.RaceCentralService;

@Controller
public class RaceCentralController {
	
	@Autowired
	RaceCentralService raceCentralService;
	
	@GetMapping("/racecentral/{id}")
	@ResponseBody
	public RaceCentral getRaceCentral(@PathVariable(name = "id") Long id) {
		RaceCentral raceCentral = raceCentralService.getCentralById(id);
		return raceCentral;
	}
	
}
