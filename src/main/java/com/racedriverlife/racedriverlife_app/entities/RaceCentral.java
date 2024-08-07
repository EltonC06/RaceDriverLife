package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "tb_race_central")
public class RaceCentral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centralId;
	
	private Integer racesWon;
	
	private Integer racesDisputed;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL) // a classe Race não pode existir sem essa
	@JoinColumn(name = "race_id", nullable = false)
	private Race race;
	
	
	
	public RaceCentral() {
		
	}

	public RaceCentral(Race race) {
		super();
		this.racesWon = 0;
		this.racesDisputed = 0;
		this.race = race;
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

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	

	public void createRace(ArrayList<String> tasksName) {
		endRace();
		for (String taskName : tasksName) {
			race.addTask(new Task(taskName, race));
		}
		race.setIsActive(true);
	}
	
	public void endRace() {
		countPoints();
		resetRace();
	}
	
	private void countPoints() {
		this.racesDisputed += 1;
		if (race.getTaskQuantity().equals(race.countCompletedTasks())) {
			this.racesWon += 1;
		}
		else {
		}
		
	}
	
	private void resetRace() {
		race.setDoneTasks(0);
		race.setTaskQuantity(0);
		race.setIsActive(false);
		race.resetTaskList();

	}

	@Override
	public int hashCode() {
		return Objects.hash(centralId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaceCentral other = (RaceCentral) obj;
		return Objects.equals(centralId, other.centralId);
	}

	
	
	
}
