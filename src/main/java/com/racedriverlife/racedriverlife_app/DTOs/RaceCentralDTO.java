package com.racedriverlife.racedriverlife_app.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RaceCentralDTO {
	
	@Min(0)
	@Max(999)
	@NotNull
	private Integer racesWon;
	
	@Min(0)
	@Max(999)
	@NotNull
	private Integer racesDisputed;
	
	public RaceCentralDTO() {
		
	}

	public RaceCentralDTO(Integer racesWon, Integer racesDisputed) {
		super();
		this.racesWon = racesWon;
		this.racesDisputed = racesDisputed;
	}

	public Integer getRacesWon() {
		return racesWon;
	}

	public void setRacesWon(Integer racesWon) {
		this.racesWon = racesWon;
	}

	public Integer getRacesDisputed() {
		return racesDisputed;
	}

	public void setRacesDisputed(Integer racesDisputed) {
		this.racesDisputed = racesDisputed;
	}
}
