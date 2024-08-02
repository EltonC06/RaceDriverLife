package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

public class RaceCentral {
	
	private Long centralId;
	private Integer racesWon = 0;
	private Integer racesDisputed = 0;
	
	private User user;
	private Race race;
	
	public RaceCentral() {
		
	}

	public RaceCentral(Long centralId, Integer racesWon, Integer racesDisputed) {
		super();
		this.centralId = centralId;
		this.racesWon = racesWon;
		this.racesDisputed = racesDisputed;
	}

	public Long getCentralId() {
		return centralId;
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
