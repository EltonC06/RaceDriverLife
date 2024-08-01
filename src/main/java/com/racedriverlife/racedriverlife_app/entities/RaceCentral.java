package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

public class RaceCentral {
	
	private Long centralId;
	
	private Integer racesWon = 0;
	private Integer racesDisputed = 0;
	
	private Race race;
	
	
	public RaceCentral() {
		
	}


	public RaceCentral(Long centralId, Integer racesWon, Integer racesDisputed, Race race) {
		super();
		this.centralId = centralId;
		this.racesWon = racesWon;
		this.racesDisputed = racesDisputed;
		this.race = race;
	}


	public Long getCentralId() {
		return centralId;
	}


	public void setCentralId(Long centralId) {
		this.centralId = centralId;
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


	public Race getRace() {
		return race;
	}

	
	public void startRace(ArrayList<Task> listOfTasks) {
		race.clearList();
		for (Task tk : listOfTasks) {
			listOfTasks.add(tk);
		}
		
		
	}
	
	
	public void endRace() {
		int totalTasks = race.getTotalTasks();
		int doneTasks = race.getDoneTasks();
		
		if (totalTasks == doneTasks) {
			racesWon += 1;
			racesDisputed += 1;
		}
		else {
			racesDisputed += 1;
		}
		race.clearList();
	}
	
	
	
	
	
	

}
