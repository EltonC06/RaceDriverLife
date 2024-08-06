package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.repositories.RaceCentralRepository;

@Service
public class RaceCentralService {
	
	@Autowired
	private RaceCentralRepository raceCentralRepository;
	
	public List<RaceCentral> getAllCentral() {
		return this.raceCentralRepository.findAll();
	}
	
	public RaceCentral getCentralById(Long id) {
		return this.raceCentralRepository.findById(id).get();
	}
	
	
}
